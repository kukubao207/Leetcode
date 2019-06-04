package LinkedList.medium;

import java.util.List;

//148. 排序链表
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
//示例 1:
//
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2:
//
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
public class SortList {
    //插入排序
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }

   // 归并排序 是采用分治法的一种排序算法：
    //分，就是把数列一分二，二分四...最后分成两两一组的最小子集
    //治，就是把分开后的子集，一一排序后归并在一起
    //和数组的归并排序相比，链表多出的一步就是如何找到链表的中点
    //利用快慢指针找到链表的中点，利用递归的方式进行分组排序
    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head);
        ListNode right = sortList1(mid.next);
        mid.next = null;
        ListNode left = sortList1(head);
        return merge(left, right);
    }

    //找出中间的节点
    //baby  这个ListNode fast为什么不是node而是node.next啊
    public ListNode findMiddle(ListNode node) {
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //对两组链表进行归并排序
    public ListNode merge(ListNode left, ListNode right){
        ListNode p = left;
        ListNode q = right;
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while(p != null && q != null){
            while(p != null && p.val <= q.val){
                tmp.next = new ListNode(p.val);
                tmp = tmp.next;
                p = p.next;
            }
            while(p!= null && q != null && q.val <= p.val){
                tmp.next = new ListNode(q.val);
                tmp = tmp.next;
                q = q.next;
            }
        }
        if(p != null)
            tmp.next = p;
        if(q != null)
            tmp.next = q;
        return dummy.next;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
