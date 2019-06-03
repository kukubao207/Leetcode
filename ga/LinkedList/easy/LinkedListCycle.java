package LinkedList.easy;
//141. 环形链表
//给定一个链表，判断链表中是否有环。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//
//
//示例 1：
//
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点
//示例 2：
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//示例 3：
//
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。

import java.util.HashSet;
import java.util.Set;

//你能用 O(1)（即，常量）内存解决此问题吗？
public class LinkedListCycle {

    //1.哈希表
    //通过检查一个结点此前是否被访问过来判断链表是否为环形链表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet();
        while (head != null){
            if(set.contains(head))
                return true;
            else
                set.add(head);
            head = head.next;
        }
        return false;
    }
    //2.双指针
    //快跑者最终一定会追上慢跑者。
    // 情况A:假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。
    //快跑者在慢跑者之后两步或三步的情况。在下一次或者下下次迭代后，又会变成上面提到的情况 A。
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow){
            if(fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
