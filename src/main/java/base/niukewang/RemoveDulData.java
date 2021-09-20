package base.niukewang;

public class RemoveDulData {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        //用例1 中间有重复元素
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(5);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        ListNode node = deleteDuplicates(listNode);

        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        //定义一个新节点FlagNode和标记为Flag，初始状态为链表初始节点，Flag为false
        //如果下一个节点为空，方法结束。
        //如果下一个节点和当前节点不一样，重新定义当前Flag节点为下一个节点，继续往后执行。如果flag为true，删除当前节点，
        //如果下一个节点和当前节点一样，那么标记Flag为true，并且删除下一个节点，再判断下下一个节点。


        //如果下一个节点为空，需要对当前节点是否需要删除做一个边界判断。
        int val= head.val;boolean flag= false;
        ListNode currentNode = head;
        ListNode preNode = null;
        while (currentNode.next!=null){
            if(currentNode.next.val!= val){
                val= currentNode.next.val;
                if(flag==true){
                    //删除当前节点
                    if(currentNode==head){
                     head=head.next;
                    }else{
                        preNode.next=currentNode.next;
                        currentNode=currentNode.next;
                    }
                    flag=false;
                }else{
                    if(preNode==null){
                        preNode=head;
                    }else {
                        preNode=currentNode;
                    }
                    currentNode=currentNode.next;
                }
            }else{
                flag=true;
                currentNode.next=currentNode.next.next;
            }
        }

        if(flag==true){
            if(currentNode==head){
                head=null;
            }else {
                preNode.next=null;
            }
        }

        return head;
    }
}
