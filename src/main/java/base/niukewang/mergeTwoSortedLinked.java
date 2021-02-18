package base.niukewang;



public class mergeTwoSortedLinked {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(8);
        ListNode l13 = new ListNode(9);
        l11.next=l12;l12.next=l13;
        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(5);
        l21.next=l22;
        //ListNode node = mergeTwoLists(l11,l21);
        ListNode node = mergeTwoListsWithoutSpace(l11,l21);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1 ,ListNode l2){
        //判断边界条件，如果l1为null，返回l2，如果l2为空，返回l1。
        //设置一个新的指针head和current，然后循环遍历l1和l2的结点，如果l1的当前结点小于l2的当前结点，
        // current指向l1的当前结点，并且l1的当前结点后移。负责l2的当前结点往后移动。如果head为null，那么head需要指向l1和l2中当前结点中较小的结点。
        // 如果l1还不为null，那么current指向l1，否则指向l2。
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=new ListNode(-1),current=head;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                ListNode listNode = new ListNode(l1.val);
                current.next=listNode;
                l1=l1.next;
            }else {
                ListNode listNode = new ListNode(l2.val);
                current.next=listNode;
                l2=l2.next;
            }
        current=current.next;
        }
        current.next=l1!=null?l1:l2;
        return head.next;
    }

    public static ListNode mergeTwoListsWithoutSpace(ListNode l1,ListNode l2){
        //边界
        if(l1==null) return l2;
        if(l2==null) return l1;
        //设置头结点
        ListNode head;
        if(l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }else {
            head=l2;
            l2=l2.next;
        }
        ListNode current = head;
        //判断l1和l2的结点大小
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                current.next=l1;
                l1=l1.next;
            }else{
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        current.next=l1!=null?l1:l2;
        return head;
    }

 }



 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }