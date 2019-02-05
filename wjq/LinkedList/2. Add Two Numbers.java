2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

思路
模拟加法
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while(l1!=null||l2!=null){
            int v1 = 0,v2 = 0;
            if(l1!=null){
                v1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                v2=l2.val;
                l2=l2.next;
            }
            int sum = v1 + v2 + carry;
            carry = sum/10;
            p.next= new ListNode(sum%10);
            p=p.next;
        }
        if(carry>0)
            p.next = new ListNode(carry);
        return dummy.next;
    }
}