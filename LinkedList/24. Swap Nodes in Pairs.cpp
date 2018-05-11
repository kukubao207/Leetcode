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
    ListNode* swapPairs(ListNode* head) {
        if(head==NULL||head->next==NULL)
            return head;

        ListNode *p=head,*q=NULL;
        head=q=p->next;
        p->next=q->next;
        q->next=p;
        while(p->next!=NULL&&p->next->next!=NULL)
        {
            q=p->next;
            p->next=q->next;
            q->next=p->next->next;
            p->next->next=q;
            p=q;
        }
        return head;
    }
};
