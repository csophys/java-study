package books.geek.datastructure_algorithm;

import base.niukewang.RemoveDulData;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * user:sheng.chen
 * date:2021/4/17
 **/
public class LinkedList {
    private static LinkNode head;

    //合并两个有序链表
    public RemoveDulData.ListNode mergeLinkNode(RemoveDulData.ListNode l1, RemoveDulData.ListNode l2) {
        //判断边界条件
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        //创建一个无数据的头结点
        RemoveDulData.ListNode temp = new RemoveDulData.ListNode(-1);
        RemoveDulData.ListNode currentNode = temp;

        //判断l1和l2链表数据的大小，直到其中一个链表的结束
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        //将还未结束的链表合并到新链表上面
        currentNode.next = l1 == null ? l2 : l1;
        return temp.next;
    }

    @BeforeClass
    public static void init() {
        head = new LinkNode(4);
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
    }

    @Test
    public void testInitLinkList() {
        //链表会有偶数情况和奇数情况。
        StringBuffer linkedListString = new StringBuffer();
        LinkNode current = head;
        while (current != null) {
            linkedListString.append(current.val);
            current = current.next;
        }
        Assert.assertEquals("412345", linkedListString.toString());
    }


    @Test
    public void testGetMiddleNode() {
        LinkNode fast = head, slow = head;
        //fast每次走两步，slow每次走一步
        //fast.next==null，链表结点数是奇数，fast.next.next==null，链表结点数是偶数。
        if (head == null) {
            return;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Assert.assertEquals(2, slow.val);
    }

    @Test
    public void testGetNTailNode(){
        Assert.assertEquals(2,getTailNLinkNode(4).val);
        Assert.assertEquals(4,getTailNLinkNode(2).val);
        Assert.assertEquals(1,getTailNLinkNode(5).val);
        Assert.assertEquals(5,getTailNLinkNode(1).val);
    }

    @Nullable
    private LinkNode getTailNLinkNode(int n) {
        LinkNode fast=head,slow=head;
        //fast先走n步。然后fast和slow开始一起前进，直到fast为null
        //fast先走n步
        for(int i = 0; i< n; i++){
            if(fast==null) {
                return null;
            }else {
                fast = fast.next;
            }
        }
        //一起前进
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
