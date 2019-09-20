package Offer;

import java.util.ArrayList;

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
