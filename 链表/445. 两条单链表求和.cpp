You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

我的解法
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode *t1=l1,*t2=l2,*pre=NULL;
        int carry=0;
        while(t1!=NULL||t2!=NULL||carry!=0)
        {
            int v1=0,v2=0;
            if(t1!=NULL)
                v1=t1->val;
            if(t2!=NULL)
                v2=t2->val;
            int now = v1 + v2 + carry;
            if(t1==NULL)
            {
                pre->next=new ListNode(now%10);
                t1=pre->next;
            }
            else
                t1->val=now%10;
            carry=now/10;
            pre=t1;
            if(t1!=NULL)
                t1=t1->next;
            if(t2!=NULL)
                t2=t2->next;
        }
        return reverseList(l1);
    }
    ListNode* reverseList(ListNode *head)
    {
        ListNode *pre=NULL;
        while(head!=NULL)
        {
            ListNode *next=head->next;
            head->next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
};

别人的解法

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}
