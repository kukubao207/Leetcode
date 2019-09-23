package Offer;
//链表中倒数第k个数
//输入一个链表，输出该链表中倒数第k个结点。
public class LastKNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode result = head;
        for (int i = 0; i < k - 1; i++) {
            head = head.next;
            if (head == null)
                return null;
        }
        while (head.next != null) {
            result = result.next;
            head = head.next;
        }
        return result;
    }
}
