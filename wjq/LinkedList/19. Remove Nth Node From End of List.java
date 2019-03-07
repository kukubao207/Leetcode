Given a linked list, remove the n-th node from the end of list and return its head.

        Example:

        Given linked list: 1->2->3->4->5, and n = 2.

        After removing the second node from the end, the linked list becomes 1->2->3->5.
        Note:

        Given n will always be valid.

        Follow up:

        Could you do this in one pass?

        Accepted
        355,511
        Submissions
        1,045,935

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int m;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        m=n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        remove(dummy);
        return dummy.next;
    }

    public void remove(ListNode head){
        if(head==null)
            return;
        remove(head.next);
        m--;
        if(m==-1){
            ListNode tmp = head.next.next;
            if(tmp!=null){
                head.next.next = null;
            }
            head.next = tmp;
        }
    }

}


还是用双指针把，两个指针保持 n+1个节点的差距，这样走的快的的指针到NULL的时候，慢的指针刚好到要删除元素的前一个
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int m;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        m=n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy,slow = dummy;
        for(int i=0;i<n+1;i++)
            fast=fast.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}