Reverse a singly linked list.
A linked list can be reversed either iteratively or recursively. Could you implement both?
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

µÝ¹éËã·¨

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head==NULL||head->next==NULL)
            return head;
        ListNode *res=reverseList(head->next);
        head->next->next=head;
        head->next=NULL;
        return res;
    }
};

µü´úËã·¨
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *pre = NULL,*cur=head;
        while(cur!=NULL)
        {
            ListNode *next=cur->next;
            cur->next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
};
