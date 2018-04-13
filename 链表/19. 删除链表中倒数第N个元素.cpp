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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* t=head;
        int sum=0;
        while(t!=NULL)
        {
            t=t->next;
            sum++;
        }
        int i=0;
        t=head;
        while(i<sum-n-1)
        {
            t=t->next;
            i++;
        }
        //ɾ��ͷ���
        if(sum-n==0)
            head=head->next;
        //ɾ��β���
        else if(n==1)
            t->next=NULL;
        //����
        else
            t->next=t->next->next;
        return head;
    }
};
