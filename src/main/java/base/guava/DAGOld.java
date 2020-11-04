package base.guava;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Data
class Node {
    String name;
    int time;
}

public class DAGOld {

    static Executor executor = Executors.newFixedThreadPool(10);
    static long beforeTime;

    public static void main(String[] args) throws InterruptedException {
        //使用Guava构造有向无环图
        final MutableGraph<Node1> DAG = GraphBuilder.directed()
                .nodeOrder(ElementOrder.insertion())
                .build();
        Node1 node1 = new Node1();
        node1.setName("d1");
        node1.setTime(3000);
        Node1 node2 = new Node1();
        node2.setName("d2");
        node2.setTime(1000);
        Node1 node3 = new Node1();
        node3.setName("d3");
        node3.setTime(1000);
        Node1 node4 = new Node1();
        node4.setName("d4");
        node4.setTime(3000);
        DAG.putEdge(node1, node3);
        DAG.putEdge(node2, node3);
        DAG.putEdge(node2, node4);
        final ConcurrentHashMap<Node1, Boolean> hashMap = new ConcurrentHashMap();
        //根据有向无环图，最优化执行链路
        beforeTime = System.currentTimeMillis();

        System.out.println("DAG的地址：" + DAG.hashCode() + ",node1的地址：" + node1.hashCode() + ",node2的地址：" + node2.hashCode() + ",node3的地址:" + node3.hashCode() + ",node4的地址：" + node4.hashCode());

        executeTask(DAG, hashMap);

    }

    private static void executeTask(final MutableGraph<Node1> DAG, final ConcurrentHashMap<Node1, Boolean> hashMap) {
        if (!DAG.nodes().isEmpty()) {
            //遍历所有的节点
            for (final Node1 node : DAG.nodes()) {
                //如果没有依赖节点，直接执行，执行后删除,并且驱动下一轮校验
                System.out.println("开始处理node：" + node);
                //使用一个set来控制是否已经在处理中了。
                if (hashMap.get(node) == null && DAG.predecessors(node).isEmpty()) {
                    System.out.println("node尚未被标记,开始处理node:" + node);
                    synchronized (node) {
                        if (hashMap.get(node) == null) {
                            hashMap.put(node, true);
                            System.out.println("node标记被处理:" + node);
                            executor.execute(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(node.getTime());
                                        System.out.println("node执行完毕，开始校验是否有后续依赖当前node节点：" + node);
                                        DAG.removeNode(node);
                                        System.out.println("从DAG中删除当前节点：" + node);
                                        executeTask(DAG, hashMap);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }

                } else {
                    if (hashMap.get(node) != null) {
                        System.out.println("当前node已经在执行中：" + node);
                    } else {
                        System.out.println("当前node还有前置节点未完成：" + node);
                    }
                }
            }
        } else {
            System.out.println("执行耗时：" + (System.currentTimeMillis() - beforeTime));
        }
    }

}
