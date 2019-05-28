package LinkedList.easy;
//21. 合并两个有序链表
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//我爱你，你是我的朱丽叶~
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)
            cur.next = l1;
        else if(l2 != null)
            cur.next = l2;
        return dummyHead.next;
    }

    //递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        else{
            if(l1.val < l2.val){
                l1.next = mergeTwoLists1(l1.next, l2);
                return l1;
            }else{
                l2.next = mergeTwoLists1(l1, l2.next);
                return l2;
            }
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
