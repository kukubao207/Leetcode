package Offer;
//两个链表的第一个公共节点
//输入两个链表，找出它们的第一个公共结点。
public class FirstCommonNodeOfTwoLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode head1 = pHead1;
        int length1 = 0;
        while(head1 != null){
            head1 = head1.next;
            length1++;
        }
        ListNode head2 = pHead2;
        int length2 = 0;
        while(head2 != null){
            head2 = head2.next;
            length2++;
        }
        int length = 0;
        ListNode p1;
        ListNode p2;
        if(length1 > length2){
            length = length1 - length2;
            p1 = pHead1;
            p2 = pHead2;
        }else{
            length = length2 - length1;
            p1 = pHead2;
            p2 = pHead1;
        }
        for(int i = 0; i < length; i++)
            p1 = p1.next;
        while(p1 != null && p2 != null){
            if(p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
