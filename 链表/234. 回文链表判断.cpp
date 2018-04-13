234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

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
    bool isPalindrome(ListNode* head) {
        if(head==NULL)
            return true;
        ListNode *fast=head,*slow=head;
        while(fast!=NULL&&fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        if(fast!=NULL)
            slow=slow->next;

        slow=reverseList(slow);

        fast=head;
        while(slow!=NULL)
        {
            if(slow->val!=fast->val)
                return false;
            slow=slow->next;
            fast=fast->next;
        }
        return true;
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

思路：
(0) slow指针和fast指针所在位置：
1 -> 1 -> 2 -> 1 -> null
sf

(1) 把slow指针移动到中间（奇数时正中间，偶数时右半部份第一个）,把fast指针移到末尾。
1 -> 1 -> 2 -> 1 -> null
          s          f

(2) 反转指针slow指向的链表
1 -> 1    null <- 2 <- 1
h                      s

(3) 对比两个链表直到slow指针指向null（指针slow指向null时，h指针一定还没有到null）。
1 -> 1    null <- 2 <- 1
     h            s
