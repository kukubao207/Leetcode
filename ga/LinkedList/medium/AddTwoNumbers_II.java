package LinkedList.medium;

import java.util.List;
import java.util.Stack;

//445. 两数相加 II
//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
//
//
//
//你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//进阶:
//
//如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//示例:
//
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
public class AddTwoNumbers_II {
    //使用两个栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur1 = l1;
        while(cur1 != null){
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        ListNode cur2 = l2;
        while(cur2 != null){
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
//        Stack res = addTwoNumbers(stack1, stack2);
//        ListNode dummy = new ListNode(0);
//        ListNode p = dummy;
//        while(!res.isEmpty()){
//            p.next = (ListNode) res.pop();
//            p = p.next;
//        }
//        return dummy.next;
        return addTwoNumbers(stack1,stack2);
    }

//    public Stack addTwoNumbers(Stack s1,Stack s2) {
//        Stack<ListNode> res = new Stack();
//        //进位符
//        int carry = 0;
//        while(!s1.isEmpty() || !s2.isEmpty()){
//            int x = !s1.isEmpty() ? (int)s1.pop() : 0;
//            int y = !s2.isEmpty() ? (int)s2.pop() : 0;
//            int sum = x + y + carry;
//            carry = sum / 10;
//            res.push(new ListNode(sum % 10));
//        }
//        if(carry > 0)
//            res.push(new ListNode(carry));
//        return res;
//    }

    public ListNode addTwoNumbers(Stack s1, Stack s2) {
        ListNode head = null;
        //进位符
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int x = !s1.isEmpty() ? (int)s1.pop() : 0;
            int y = !s2.isEmpty() ? (int)s2.pop() : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        if(carry > 0){
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
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
