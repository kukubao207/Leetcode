package LinkedList.medium;
//92. 反转链表 II
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
//示例:
//
//输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
public class ReverseLinkedList_II {
    //直接翻转
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1 ; i < m; i++){
            pre = pre.next;
        }
        cur = pre.next;
        ListNode aft = cur;
        ListNode p = null;
        for(int i = 0; i <= n - m; i++){
            ListNode q = cur.next;
            cur.next = p;
            p = cur;
            cur = q;
        }
        aft.next = cur;
        pre.next = p;
        return dummy.next;
    }
    //别人的思路
    //实现思路 ：以1->2->3->4->5, m = 2, n=4 为例:
    //定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
    //当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
   // 当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            pre.next = next;
        }
        return dummy.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
