147. Insertion Sort List
Sort a linked list using insertion sort.

我的解法 90ms
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

别人的解法 45ms
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


改进 24ms
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

思路：
cur用来指向现在取出即将进行插入的原始链表中的元素。
1.新建一个链表作为结果链表
2.将该元素插入结果链表，具体应该插入到pre和pre.next之间。
    2.1.每次插入完毕之后，pre可以直接重置到结果链表的起点。
    2.2.改进方法：做一下判断，是不是比下一个元素大，如果比下一个插入元素小，其实不需要充值pre指针。
3.重复步骤2，直到原始链表中的元素全部插入完毕，也就是cur指向末尾NULL的时候。
