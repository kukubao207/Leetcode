package LinkedList.medium;
//61. 旋转链表
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//
//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//示例 2:
//
//输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
public class RotateList {
    //1、将链表首尾连起来
    // 2、计算链表长度 L，则 迭代 L - k % L 次就是新的链表头
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        int length = 1;
        while(cur.next != null){
            length++;
            cur = cur.next;
        }
        cur.next = head;
        int loop = length - k % length;
        if(loop == length)
            loop = 0;
        for(int i = 0; i < loop; i++){
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
