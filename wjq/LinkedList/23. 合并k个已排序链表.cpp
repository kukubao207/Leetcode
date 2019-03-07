23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty())
            return NULL;
        ListNode* result=lists[0];
        int sz=lists.size();
        while(sz>1)
        {
            for(int i=0,j=sz-1;i<sz/2;i++,j--)
                lists[i]=mergeTwoLists(lists[i],lists[j]);
            if(sz%2==1)
                sz=sz/2+1;
            else
                sz=sz/2;
        }
        return lists[0]!=NULL?lists[0]:NULL;
    }
    ListNode* mergeTwoLists(ListNode *l1,ListNode *l2)
    {
        ListNode resultHead(0);
        ListNode* p=&resultHead;
        while(l1&&l2)
        {
            if(l1->val<l2->val)
            {
                p->next=l1;
                l1=l1->next;
            }
            else
            {
                p->next=l2;
                l2=l2->next;
            }
            p=p->next;
        }
        p->next= l1?l1:l2;
        return resultHead.next;
    }
};

思路：合并k个已经排序的链表，本题的基础可以在合并两个链表的基础上
完成，比如说，

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }
    public ListNode partion(ListNode[] list, int s,int e){
        if(s==e){
            return list[s];
        }else if(s<e){
            int m = (s+e)/2;
            ListNode left = partion(list,s,m);
            ListNode right = partion(list,m+1,e);
            return mergeTwo(right,left);
        }else{
            return null;
        }
    }
    public ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode d = new ListNode(0);
        ListNode dummy = d;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                dummy.next=l1;
                l1=l1.next;
            }else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        dummy.next = l1==null? l2:l1;
        return d.next;
    }
}