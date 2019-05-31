package LinkedList.easy;

import java.util.List;

//206. 反转链表
//反转一个单链表。
//
//示例:
//
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
public class ReverseLinkedList {
    //迭代
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode aft = cur.next;
            cur.next = pre;
            pre = cur;
            cur = aft;
        }
        return pre;
    }
    //递归
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = reverseList1(head.next);
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        ListNode res = cur.next.next;
        cur.next.next = null;
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
