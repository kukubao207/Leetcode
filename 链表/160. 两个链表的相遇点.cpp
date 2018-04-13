160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 �� a2
                   �K
                     c1 �� c2 �� c3
                   �J
B:     b1 �� b2 �� b3
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

˼·��
    ������Ҫ�����������ʼ�ϲ����Ǹ��ڵ㡣���ǿ����������ָ��ֱ�ָ��һ��������
    ��������ת����������ָ����������⣬���ǿ������������Լ�����������ָ�룬��
    ��һ���������ͷ�������ܣ�����һ���������ϵĺ������ָ�룬�����Լ��ĵ�����֮
    ��Ҳȥ�Է��ĵ������ϼ����ܡ���������ָ����ܾ���һ������ͬ�ģ�������ǳ������
    ����ֻҪ���������Ƿ�ΪNULL����֪���������������Ƿ�����غϵĵ��ˡ�

