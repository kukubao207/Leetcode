package LinkedList.medium;

import java.util.List;

//147. 对链表进行插入排序
//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//
//
//插入排序算法：
//
//插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//重复直到所有输入数据插入完为止。
//
//
//示例 1：
//
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2：
//
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
public class InsertionSortList {
    //递归
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        if(head == null || head.next == null)
            return head;
        ListNode subSortList = insertionSortList(head.next);
        dummy.next = subSortList;
        ListNode cur = subSortList;
        ListNode pre = null;
        while(cur != null){
            if(cur.val >= head.val){
                if(pre != null){
                    pre.next = head;
                    head.next = cur;
                }else{
                    dummy.next = head;
                    head.next = cur;
                }
                return dummy.next;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = head;
        head.next = null;
        return dummy.next;
    }

    //迭代
    public ListNode insertionSortList1(ListNode head) {
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



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
