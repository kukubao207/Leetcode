Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4

class Solution {
public:
    ListNode* plusOne(ListNode* head) {
        head=reverseList(head);
        ListNode *cur=head,*pre=cur;
        int jinwei=1,now=0;
        while(cur!=NULL)
        {
            pre=cur;
            now=cur->val+jinwei;
            cur->val=now%10;
            jinwei=now/10;
            if(jinwei==0)
                break;
            cur=cur->next;
        }
        if(jinwei==1)
            pre->next=new ListNode(1);
        return reverseList(head);
    }
    ListNode* reverseList(ListNode* head)
    {
        ListNode *pre=NULL;
        while(head!=NULL)
        {
            ListNode *next=head->next;
            head->next=pre;
            head=next;
            pre=head;
        }
        return pre;
    }
};


思路：单链表直接进行加一运算是违背加法的原理的，因为加法进位需要从低位慢慢
向上。因此我们将单链表先进行反转，然后边访问单链表边进行加法运算，运算完成
之后再反转链表，返回该指针即可。
