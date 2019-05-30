package LinkedList.medium;
//82. 删除排序链表中的重复元素 II
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
//示例 1:
//
//输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//示例 2:
//
//输入: 1->1->1->2->3
//输出: 2->3
public class RemoveDuplicatesFromSortedList_II {
    //递归
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        while(next != null && head.val == next.val){
            next = next.next;
        }
        if(head.next == next)
            head.next = deleteDuplicates(head.next);
        else{
            head = deleteDuplicates(next);
        }
        return head;
    }
    //迭代
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur = cur.next;
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                p.next = new ListNode(cur.val);
                cur = cur.next;
                p = p.next;
            }
        }
        p.next = cur;
        return dummy.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
