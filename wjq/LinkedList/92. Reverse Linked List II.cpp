92. Reverse Linked List II
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode *dummy=new ListNode(0);
        dummy->next=head;
        ListNode *mNode=NULL,*mLastNode=NULL;
        ListNode *cur=dummy,*pre=NULL,*next=NULL;
        int num=0;
        while(cur!=NULL&&num<=n)
        {
            next=cur->next;
            if(num==m-1)
                mLastNode=cur;
            else if(num==m)
                mNode=cur;
            else if(num>m)
                cur->next=pre;
            num++;
            pre=cur;
            cur=next;
        }
        mLastNode->next=pre;
        mNode->next=cur;
        return dummy->next;

    }
};
别人的解法
The basic idea is as follows:

(1) Create a new_head that points to head and use it to locate the immediate node before the m-th (notice that it is 1-indexed) node pre;

(2) Set cur to be the immediate node after pre and at each time move the immediate node after cur (named move) to be the immediate node after pre. Repeat it for n - m times.

class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode* new_head = new ListNode(0);
        new_head -> next = head;
        ListNode* pre = new_head;
        for (int i = 0; i < m - 1; i++)
            pre = pre -> next;
        ListNode* cur = pre -> next;
        for (int i = 0; i < n - m; i++) {
            ListNode* move = cur -> next;
            cur -> next = move -> next;
            move -> next = pre -> next;
            pre -> next = move;
        }
        return new_head -> next;
    }
};

思路：
我的思路不太好，应该先跳过<m的部分。
