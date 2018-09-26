61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.

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
    ListNode* rotateRight(ListNode* head, int k) {
        if(head==NULL)
            return NULL;
        //1. compute the length of list and locate the cur pointer to the tail of list.
        ListNode *cur=head;
        int len=1;
        while(cur->next!=NULL)
        {
            cur=cur->next;
            len++;
        }

        //2. make a circle
        cur->next=head;

        //3. cut the circle
        k=len-k%len;
        while(k--)
            cur=cur->next;
        ListNode *result=cur->next;
        cur->next=NULL;
        return result;
    }
};

别人的思路和我类似

There is no trick for this problem. Some people used slow/fast pointers to find the tail node but I don’t see the benefit (in the sense that it doesn’t reduce the pointer move op) to do so. So I just used one loop to find the length first.

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head) return head;

        int len=1; // number of nodes
        ListNode *newH, *tail;
        newH=tail=head;

        while(tail->next)  // get the number of nodes in the list
        {
            tail = tail->next;
            len++;
        }
        tail->next = head; // circle the link

        if(k %= len)
        {
            for(auto i=0; i<len-k; i++) tail = tail->next; // the tail node is the (len-k)-th node (1st node is head)
        }
        newH = tail->next;
        tail->next = NULL;
        return newH;
    }
};
