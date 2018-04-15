Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

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
    ListNode* partition(ListNode* head, int x) {

        ListNode *Smaller=new ListNode(0),*s=Smaller;
        ListNode *Bigger=new ListNode(0),*b=Bigger;
        ListNode *cur=head,*next=NULL;

        while(cur!=NULL)
        {
            next=cur->next;
            if(cur->val<x)
            {
                s->next=cur;
                s=cur;
            }
            else
            {
                b->next=cur;
                b=cur;
            }
            cur->next=NULL;
            cur=next;
        }
        s->next=Bigger->next;
        return Smaller->next;
    }
};
别人的解法
ListNode *partition(ListNode *head, int x) {
    ListNode node1(0), node2(0);
    ListNode *p1 = &node1, *p2 = &node2;
    while (head) {
        if (head->val < x)
            p1 = p1->next = head;
        else
            p2 = p2->next = head;
        head = head->next;
    }
    p2->next = NULL;
    p1->next = node2.next;
    return node1.next;
}

思路
我和别人的解法大致是一样的，但是他的方法里不需要每次将新加入的结点的下一个结点置为NULL，
因为只需要循环到最后把最后一个结点b->next=NULL就可以了，这是我需要改进的地方。
