package LinkedList.medium;
//24. 两两交换链表中的节点
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
//示例:
//
//给定 1->2->3->4, 你应该返回 2->1->4->3.
public class SwapNodesInPairs {

    //递归
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    //迭代
    public static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            p.next = new ListNode(cur.next.val);//北鼻  如果直接写成p.next=cur.next
            p.next.next = new ListNode(cur.val);//p.next.next=cur会死循环 这个过程啥样啊
            cur = cur.next.next;
            p = p.next.next;
        }
        if(cur != null)
            p.next = cur;
        return dummy.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
