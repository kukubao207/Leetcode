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

˼·��
(0) slowָ���fastָ������λ�ã�
1 -> 1 -> 2 -> 1 -> null
sf

(1) ��slowָ���ƶ����м䣨����ʱ���м䣬ż��ʱ�Ұ벿�ݵ�һ����,��fastָ���Ƶ�ĩβ��
1 -> 1 -> 2 -> 1 -> null
          s          f

(2) ��תָ��slowָ�������
1 -> 1    null <- 2 <- 1
h                      s

(3) �Ա���������ֱ��slowָ��ָ��null��ָ��slowָ��nullʱ��hָ��һ����û�е�null����
1 -> 1    null <- 2 <- 1
     h            s
