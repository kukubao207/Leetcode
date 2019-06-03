package LinkedList.medium;

import java.util.HashSet;

//142. 环形链表 II
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//说明：不允许修改给定的链表。
//
//
//
//示例 1：
//
//输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//示例 2：
//
//输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//示例 3：
//
//输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
//
//
//
//
//进阶：
//你是否可以不用额外空间解决此题？
public class LinkedListCycle_II {
    //1.用哈希
    //记录环开始的地方
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        while(head != null){
            if(set.contains(head))
                return head;
            else
                set.add(head);
            head = head.next;
        }
        return null;
    }

    //2.快慢指针
    //设环的起始节点为 E，快慢指针从 head 出发，快指针速度为 2
    // 设相交节点为 X，head 到 E 的距离为 H，E 到 X 的距离为 D，环的长度为 L
    // 那么有：快指针走过的距离等于慢指针走过的距离加快指针多走的距离（多走了 n 圈的 L） 2(H + D) = H + D + nL
    // 因此可以推出 H = nL - D，这意味着如果我们让俩个慢指针一个从 head 出发，一个从 X 出发的话，他们一定会在节点 E 相遇
    //                   _____
    //                 /      \
    //head___________E         \
    //                \       /
    //                 X_____/
    public ListNode detectCycle1(ListNode head) {
        if(head == null || head.next == null)
            return null;
//        ListNode fast = head.next;
//        ListNode slow = head;
//        while(fast != slow){
//            if(fast == null || fast.next == null)
//                return null;
//            fast = fast.next.next;
//            slow = slow.next;
//        }
        //快慢指针从头开始
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }

        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
