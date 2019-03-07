25. Reverse Nodes in k-Group

        Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

        k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

        Example:

        Given this linked list: 1->2->3->4->5

        For k = 2, you should return: 2->1->4->3->5

        For k = 3, you should return: 3->2->1->4->5

        Note:

        Only constant extra memory is allowed.
        You may not alter the values in the list's nodes, only nodes itself may be changed.


思路
这题要用递归做，一定要理解，回溯点在哪
回溯点应该是回溯到上一次 count==k  的那个地方，也就是每次要被翻转的链表的起始位置。
为了构造出这种回溯点， 每次在递归之前，需要让链表向前移动k个位置，如果链表还没有移动k个位置就已经遇到null，
说明这个链表不需要翻转，直接返回head就可以了。
对于回溯到上一层的起始点之后，需要把该起始点往后的k-1个节点进行链表逆转，用到了三个指针  prev tmp next
翻转完成之后,prev会指向链表末尾，把这个prev返回给上一层即可， 不能忘记要把head.next指向  刚才返回的值。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head,k);
    }
    public ListNode reverse(ListNode head,int k){
        int count=0;
        ListNode cur = head;
        while(cur!=null&&count!=k){
            cur=cur.next;
            count++;
        }
        if(count<k)
            return head;
        if(count==k){
            //在这里要对链表翻转
            ListNode front = reverse(cur,k);
            ListNode tmp = head.next,prev=head;
            while(--count>0){
                ListNode next = tmp.next;
                tmp.next = prev;
                prev = tmp;
                tmp = next;
            }
            head.next = front;
            return prev;
        }
        return head;
    }
}