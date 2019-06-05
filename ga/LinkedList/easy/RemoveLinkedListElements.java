package LinkedList.easy;
//203. 移除链表元素
//删除链表中等于给定值 val 的所有节点。
//
//示例:
//
//输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
public class RemoveLinkedListElements {
    //构建新节点
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode p = dummy;
        while(cur != null){
           if(cur.val != val){
               p.next = new ListNode(cur.val);
               p = p.next;
           }
            cur = cur.next;
        }
        p.next = null;
        return dummy.next;
    }

    //递归
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode nextHead = removeElements1(head.next, val);
        if(head.val == val)
            head = nextHead;
        else if(head.val != val)
            head.next = nextHead;
        return head;
    }

    //虚拟节点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return dummy.next;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
