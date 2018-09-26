Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4

class Solution {
public:
    ListNode* plusOne(ListNode* head) {
        head=reverseList(head);
        ListNode *cur=head,*pre=cur;
        int jinwei=1,now=0;
        while(cur!=NULL)
        {
            pre=cur;
            now=cur->val+jinwei;
            cur->val=now%10;
            jinwei=now/10;
            if(jinwei==0)
                break;
            cur=cur->next;
        }
        if(jinwei==1)
            pre->next=new ListNode(1);
        return reverseList(head);
    }
    ListNode* reverseList(ListNode* head)
    {
        ListNode *pre=NULL;
        while(head!=NULL)
        {
            ListNode *next=head->next;
            head->next=pre;
            head=next;
            pre=head;
        }
        return pre;
    }
};


˼·��������ֱ�ӽ��м�һ������Υ���ӷ���ԭ��ģ���Ϊ�ӷ���λ��Ҫ�ӵ�λ����
���ϡ�������ǽ��������Ƚ��з�ת��Ȼ��߷��ʵ�����߽��мӷ����㣬�������
֮���ٷ�ת�������ظ�ָ�뼴�ɡ�
