83. Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

迭代方法
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL)
            return NULL;
        ListNode *pre=head,*cur=head->next;
        while(cur!=NULL)
        {
            if(cur->val==pre->val)
                pre->next=cur->next;
            else
                pre=cur;
            cur=cur->next;
        }
        return head;
    }
};

递归方法
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {

        if(head==NULL||head->next==NULL)
            return head;
        head->next=deleteDuplicates(head->next);
        if(head->val==head->next->val)
            return head->next;
        else
            return head;
    }
};
