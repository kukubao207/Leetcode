package LinkedList.medium;
//19. 删除链表的倒数第N个节点
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//示例：
//
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//说明：
//
//给定的 n 保证是有效的。
//
//进阶：
//
//你能尝试使用一趟扫描实现吗？
public class RemoveNthNodeFromTheEndOfList {
    //两次遍历O(L)
    // 首先计算了列表的长度L
    // 其次找到第 (L - n)个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);//设置哑变量
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while(first != null){
            length++;
            first = first.next;
        }
        length = length - n;
        first = dummy;
        while(length > 0){
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    //一次遍历O(L)
    //第一个指针从列表的开头向前移动 n+1 步
    //第二个指针将从列表的开头出发。
    // 这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点(到达Null)。
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0; i <= n ; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public class ListNode
    {
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }

}
