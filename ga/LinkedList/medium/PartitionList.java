package LinkedList.medium;
//86. 分隔链表
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//你应当保留两个分区中每个节点的初始相对位置。
//
//示例:
//
//输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode res = small;
        ListNode big = new ListNode(0);
        ListNode p = big;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                small.next = new ListNode(cur.val);
                small = small.next;
            }
            else{
                big.next = new ListNode(cur.val);
                big = big.next;
            }
            cur = cur.next;
        }
        small.next = p.next;
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
