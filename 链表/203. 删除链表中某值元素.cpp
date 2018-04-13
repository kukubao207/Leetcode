203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

迭代方法
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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode *dummy=new ListNode(val-1);
        dummy->next=head;
        ListNode *cur=dummy;
        while(cur!=NULL&&cur->next!=NULL)
        {
            if(cur->next->val==val)
                cur->next=cur->next->next;
            else
                cur=cur->next;
        }
        return dummy->next;
    }
};

递归方法
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        if(head==NULL)
            return NULL;

        head->next=removeElements(head->next,val);
        if(head->val==val)
            return head->next;
        else
            return head;
    }
};
