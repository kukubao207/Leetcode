package LinkedList.medium;
//2. 两数相加
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //虚拟节点
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        //进位符
        int carry = 0;
        //只要两个链表有一个不为空就继续循环
        while(p != null || q != null){
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            //重新计算进位
            carry = sum / 10;
            //注意取模运算得到本位数值
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        //循环结算，考虑还有最后一次进位的情况
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        //虚拟节点的下一节点为最终结果
        return dummyHead.next;
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
