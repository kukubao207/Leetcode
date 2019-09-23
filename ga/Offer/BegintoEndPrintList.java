package Offer;

import java.util.ArrayList;
//从头到尾打印链表
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class BegintoEndPrintList {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return new ArrayList<Integer>();
        ArrayList<Integer> list = printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
