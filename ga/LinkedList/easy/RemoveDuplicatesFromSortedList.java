package LinkedList.easy;
//83. 删除排序链表中的重复元素
public class RemoveDuplicatesFromSortedList {
    //遍历
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                p.next = new ListNode(cur.val);
                p = p.next;
                cur = cur.next;
            }else{
                cur = cur.next;
            }
        }
        p.next = cur;
        return dummy.next;
    }
    //遍历
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        while(p != null && p.next != null){
            if(p.val != p.next.val)
                p = p.next;
            else{
                p.next = p.next.next;
            }
        }
        return head;
    }
    //递归
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates2(head.next);
        if(head.val == head.next.val)
            head = head.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
