147. Insertion Sort List
Sort a linked list using insertion sort.

�ҵĽⷨ 90ms
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
    ListNode* insertionSortList(ListNode* head) {
        if(head==NULL)
            return NULL;
        ListNode *dummy=new ListNode(INT_MIN);
        dummy->next=head;
        ListNode *cur=head->next;
        while(cur!=NULL)
        {
            ListNode *start=dummy,*startPre=dummy;
            while(start!=head->next)
            {
                if(start->val>cur->val)
                {
                    head->next=cur->next;
                    startPre->next=cur;
                    cur->next=start;
                    break;
                }
                startPre=start;
                start=start->next;
            }
            if(start==head->next)
                head=cur;
            cur=head->next;
        }
        return dummy->next;
    }
};

���˵Ľⷨ 45ms
public ListNode insertionSortList(ListNode head) {
    if( head == null ){
        return head;
    }

    ListNode helper = new ListNode(0); //new starter of the sorted list
    ListNode cur = head; //the node will be inserted
    ListNode pre = helper; //insert node between pre and pre.next
    ListNode next = null; //the next node will be inserted
    //not the end of input list
    while( cur != null ){
        next = cur.next;
        //find the right place to insert
        while( pre.next != null && pre.next.val < cur.val ){
			pre = pre.next;
        }
        //insert between pre and pre.next
        cur.next = pre.next;
        pre.next = cur;
        pre = helper;
        cur = next;
    }
    return helper.next;
}


�Ľ� 24ms
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
    ListNode* insertionSortList(ListNode* head) {
        if(head==NULL)
            return NULL;
        ListNode *dummy=new ListNode(INT_MIN);
        ListNode *pre=dummy;
        ListNode *cur=head;
        ListNode *next=NULL;
        while(cur!=NULL)
        {
            next=cur->next;
            if(pre!=NULL&&pre->next!=NULL&&pre->next->val>=cur->val)
                pre=dummy;
            while(pre->next!=NULL&&cur->val>pre->next->val)
                pre=pre->next;
            cur->next=pre->next;
            pre->next=cur;
            cur=next;
        }
        return dummy->next;
    }
};

˼·��
cur����ָ������ȡ���������в����ԭʼ�����е�Ԫ�ء�
1.�½�һ��������Ϊ�������
2.����Ԫ�ز�������������Ӧ�ò��뵽pre��pre.next֮�䡣
    2.1.ÿ�β������֮��pre����ֱ�����õ�����������㡣
    2.2.�Ľ���������һ���жϣ��ǲ��Ǳ���һ��Ԫ�ش��������һ������Ԫ��С����ʵ����Ҫ��ֵpreָ�롣
3.�ظ�����2��ֱ��ԭʼ�����е�Ԫ��ȫ��������ϣ�Ҳ����curָ��ĩβNULL��ʱ��
