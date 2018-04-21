Sort a linked list in O(n log n) time using constant space complexity.

我的解法 94ms
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
    ListNode* sortList(ListNode* head) {
        //只剩下一个元素，那么这一个元素的链表一定排好序了。
        if(head==NULL||head->next==NULL)
            return head;
        ListNode *slow=head,*fast=head,*preSlow=NULL;
        while(fast!=NULL&&fast->next!=NULL)
        {
            preSlow=slow;
            slow=slow->next;
            fast=fast->next->next;
        }
        preSlow->next=NULL;
        ListNode *listOne=sortList(head);
        ListNode *listTwo=sortList(slow);
        return merge(listOne,listTwo);
    }
    ListNode* merge(ListNode* l1,ListNode* l2)
    {
        ListNode *dummy=new ListNode(0),*p=dummy;
        while(l1!=NULL&&l2!=NULL)
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
        p->next=l1?l1:l2;
        return dummy->next;
    }
};

别人的解法
归并排序
public class Solution {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    // step 1. cut the list to two halves
    ListNode prev = null, slow = head, fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;

    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    // step 3. merge l1 and l2
    return merge(l1, l2);
  }

  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null)
      p.next = l1;

    if (l2 != null)
      p.next = l2;

    return l.next;
  }

}
快速排序 47ms

There are many merge-sort solutions at the forum, but very few quicksort solutions. So I post my accepted quicksort solution here.

Well, after reading the problem statement, I intuitively select quicksort since it is able to give an in-place solution and thus costs only constant space. Also, it is O(nlogn) in the expected case though it may become O(n^2) in the worst case.

Then I implement my quicksort solution and test it. I then submit it to the online judge. However, the annoying TLE error occurred. I check for the forums and some people suggested to use random pivoting or duplicate skipping. However, implementing random pivoting is a little costly, I lazily tried to skip the duplicates. And it works! So now comes the following solution . Note that each time I choose the first node as the pivot. Moreover, I create a new_head that points to head for convenience.

Of course, this solution passes the online judge luckily. If the linked list is like: 100000 -> 99999 -> 99998 -> ... -> 1, it will fail since the subproblems only decrease by 1 at each recursion. However, it seems that the LeetCode OJ does not have this kind of test cases.

class Solution {
public:
    void sortListHelper(ListNode* head, ListNode* tail) {
    	if (head -> next == tail)
            return;
    	/* Partition the list. */
    	ListNode* pre = head;
    	ListNode* cur = head -> next;
    	ListNode* pivot = cur;
    	while (cur -> next && cur -> next != tail) {
    		if (pivot -> val > cur -> next -> val) {
    			ListNode* temp = pre -> next;
    			pre -> next = cur -> next;
    			cur -> next = cur -> next -> next;
    			pre -> next -> next = temp;
    		}
    		else cur = cur -> next;
    	}
    	sortListHelper(head, pivot);
    	/* Here is the trick. */
    	while (pivot -> next != tail && pivot -> next -> val == pivot -> val)
    	    pivot = pivot -> next;
        sortListHelper(pivot, tail);
    }

    ListNode* sortList(ListNode* head) {
    	ListNode* new_head = new ListNode(0);
    	new_head -> next = head;
    	sortListHelper(new_head, NULL);
    	return new_head -> next;
    }

};
