package yitukeji;

import LinkedList.easy.ReverseLinkedList;

public class test2 {
    public static class ListNode {
        ListNode next;
        int val;
    }

    public static void main(String[] args) {
        System.out.println("1231");
        test();
    }

    public static void test() {

    }

    public ListNode reverse(ListNode h) {
        if (h == null || h.next == null)
            return h;
        ListNode c = h, p = null, a = null;
        while (c != null ) {
            a = c.next;
            c.next = p;
            p = c;
            c = a;
        }
        return p;
    }

}
