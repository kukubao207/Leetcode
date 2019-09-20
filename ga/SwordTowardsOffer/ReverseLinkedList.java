package SwordTowardsOffer;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    //1.递归
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //2.迭代
    public ListNode reverse1(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this .val = val;
        }
    }
}
