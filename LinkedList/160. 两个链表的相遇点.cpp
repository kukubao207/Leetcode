160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.


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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA==NULL||headB==NULL)
            return NULL;
        ListNode *dummyA=headA,*dummyB=headB;
        while(dummyA!=dummyB)
        {
            if(dummyA==NULL)
                dummyA=headB;
            else
                dummyA=dummyA->next;
            if(dummyB==NULL)
                dummyB=headA;
            else
                dummyB=dummyB->next;
        }
        return dummyA;
    }
};

思路：
    这题是要求出两个链表开始合并的那个节点。我们可以设计两个指针分别指向一条单链表，
    这个问题就转化成了两个指针的相遇问题，我们可以让先跑完自己这个单链表的指针，从
    另一个单链表的头结点继续跑；而另一个单链表上的后跑完的指针，跑完自己的单链表之
    后也去对方的单链表上继续跑。这样两个指针的总距离一定是相同的，因此他们迟早会相
    遇，只要看相遇点是否为NULL，就知道这两条单链表是否具有重合的点了。

