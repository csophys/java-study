package base.niukewang;

//顶一个链表类
class Node {
    int val;
    Node next;
    Node(int val){
        this.val =val;
    }
}

public class MergeTwoSortLinkedList{


    public static void main(String[] args) {
        Node list1=null ,list2=null;
        list1 = new Node(2);
        list2 = new Node(1);
        Node list11 = new Node(3);
        Node list21 = new Node(2);
        Node list12 = new Node(6);
        Node list22 = new Node(4);
        list1.next=list11;list11.next=list12;
        list2.next=list21;list21.next=list22;
        //边界条件判断
        if(list1==null) {}
        if(list2==null) {}
        //合并两个链表
        Node currentNode = new Node(-1);
        Node startNode = currentNode;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                currentNode.next=list1;
                list1=list1.next;
            }else{
                currentNode.next=list2;
                list2=list2.next;
            }
            currentNode = currentNode.next;
        }
        //处理一个链表结束的时候
        currentNode.next=list1!=null?list1:list2;

        while(startNode.next!=null){
            System.out.println(startNode.next.val);
            startNode=startNode.next;
        }
    }
}
