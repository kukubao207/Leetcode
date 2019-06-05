package LinkedList.easy;
//234. 回文链表
//请判断一个链表是否为回文链表。
//
//示例 1:
//
//输入: 1->2
//输出: false
//示例 2:
//
//输入: 1->2->2->1
//输出: true
//进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
public class PalindromeLinkedList {
    //翻转后半部分 然后遍历
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        //快慢指针寻找中心点(偶数为中间偏后的点)
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null){
            if(head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //递归逆序
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode nextHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
