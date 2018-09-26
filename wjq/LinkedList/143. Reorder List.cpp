143. Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

我的思路
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
    void reorderList(ListNode* head) {
        if(head==NULL)
            return;
        //1.reverse the second half of the List.
        ListNode *slow=head,*fast=head;
        while(fast!=NULL&&fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        ListNode *head2=reverseList(slow);
        slow->next=NULL;

        //2.change the pointer of every node.
        ListNode *cur1=head,*cur2=head2;
        while(cur2->next!=NULL)
        {
            ListNode *cur1Next=cur1->next,*cur2Next=cur2->next;
            cur1->next=cur2;
            cur2->next=cur1Next;
            cur1=cur1Next;
            cur2=cur2Next;
        }
    }
    ListNode *reverseList(ListNode *head)
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
别人的思路 大同小异。
