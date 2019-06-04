package LinkedList.medium;

import java.util.LinkedList;

//143. 重排链表
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//示例 1:
//
//给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//示例 2:
//
//给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
public class ReorderList {
    //双向队列
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while(cur != null){
            queue.addLast(cur);
            cur = cur.next;
        }
        while(!queue.isEmpty()){
            if(cur == null){
                cur = queue.pollFirst();
            }else{
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if(cur != null)
            cur.next = null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
