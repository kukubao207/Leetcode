package Offer;

public class MergeTwoSortingListNode {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
