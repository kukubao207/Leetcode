82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL)
            return NULL;
        ListNode *dummy=new ListNode(head->val+1),*pre=dummy,*cur=head;
        dummy->next=head;
        bool duplicate=false;
        while(pre!=NULL&&pre->next!=NULL)
        {
            duplicate=false;
            while(cur->next!=NULL&&cur->next->val==cur->val)
            {
                cur=cur->next;
                duplicate=true;
            }
            if(duplicate)
                pre->next=cur->next;
            else
                pre=cur;
            cur=cur->next;
        }
        return dummy->next;
    }
};

看了别人的代码之后的改进代码，其实差不多，就是简化了duplicate的判断。
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL)
            return NULL;
        ListNode *dummy=new ListNode(head->val+1),*pre=dummy,*cur=head;
        dummy->next=head;
        while(pre!=NULL&&pre->next!=NULL)
        {
            while(cur->next!=NULL&&cur->next->val==cur->val)
                cur=cur->next;
            if(pre->next!=cur) //duplicate
                pre->next=cur->next;
            else
                pre=cur;
            cur=cur->next;
        }
        return dummy->next;
    }
};
