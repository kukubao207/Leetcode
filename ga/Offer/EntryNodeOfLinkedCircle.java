package Offer;

/**链表中环的入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLinkedCircle {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null || pHead.next.next == null)
            return null;
        ListNode first = pHead.next.next;
        ListNode slow = pHead.next;
        while(first != slow){
            if(first == null || first.next == null)
                return null;
            first = first.next.next;
            slow = slow.next;
        }
        ListNode head = pHead;
        while(first != head){
            first = first.next;
            head = head.next;
        }
        return head;
    }
}
