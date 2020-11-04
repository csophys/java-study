package base.guava;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Data
class Node1 {
    String name;
    int time;
}


public class DAG {
    static Executor executor = Executors.newFixedThreadPool(10);
    public static void main(String[] args){
        //使用Guava构造有向无环图
        final MutableGraph<Node1> DAG = GraphBuilder.directed()
                .nodeOrder(ElementOrder.insertion())
                .build();
        Node1 node1 = new Node1();node1.setName("d1");node1.setTime(3000);
        Node1 node2 = new Node1();node2.setName("d2");node2.setTime(1000);
        Node1 node3 = new Node1();node3.setName("d3");node3.setTime(1000);
        Node1 node4 = new Node1();node4.setName("d4");node4.setTime(3000);
        DAG.putEdge(node1, node3);DAG.putEdge(node2, node3);DAG.putEdge(node2, node4);
        final ConcurrentHashMap<Node1, Boolean> hashMap = new ConcurrentHashMap();
        if(!ExistedLoop(DAG)){
            //根据有向无环图，最优化执行链路
            executeTask(DAG, hashMap);
        }
    }
    private static void executeTask(final MutableGraph<Node1> DAG, final ConcurrentHashMap<Node1, Boolean> hashMap) {
        if (!DAG.nodes().isEmpty()) {
            //遍历所有的节点
            for (final Node1 node : DAG.nodes()) {
                //如果没有依赖节点，并且尚未执行中，开始尝试执行当前节点
                if (hashMap.get(node) == null && DAG.predecessors(node).isEmpty()) {
                    synchronized (node) {
                        if (hashMap.get(node) == null) {
                            //执行当前当前节点
                            hashMap.put(node, true);
                            executor.execute(new Runnable() {
                                @Override
                                public void run() {
                                        System.out.println("正在执行当前节点...");
                                        DAG.removeNode(node);
                                        executeTask(DAG, hashMap);
                                }
                            });
                        }
                    }
                }
            }
        }
    }


    private static boolean ExistedLoop(MutableGraph<Node1> dag) {
        return false;
    }
}
