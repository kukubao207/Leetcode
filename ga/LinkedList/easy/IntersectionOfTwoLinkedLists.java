package LinkedList.easy;

import java.util.HashSet;
import java.util.List;

//160. 相交链表
//编写一个程序，找到两个单链表相交的起始节点。
//
//如下面的两个链表：
//
//
//
//在节点 c1 开始相交。
//
//
//
//示例 1：
//
//
//
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
public class IntersectionOfTwoLinkedLists {
    //把节点用hash表记录下来
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        HashSet<ListNode> set = new HashSet<>();
        while(p != null){
           set.add(p);
            p = p.next;
        }
        while(q != null){
            if(set.contains(q))
                return q;
            q = q.next;
        }
        return null;
    }
    //链表1的长度是x1+y，链表2的长度是x2+y
    // 我们同时遍历链表1和链表2，到达末尾时，再指向另一个链表。则当两链表走到相等的位置时：
    //x1+y+x2 = x2+y+x1
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode p = headA;
        ListNode q = headB;
        while(p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    //先求两个链表的长度，
    // 然后在让相对长的链表走到跟短链表相同长度的位置，然后再一起遍历，找到相等（位置，地址都相等，这里是个坑）的位置，返回。
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while(p != null){
            lengthA++;
            p = p.next;
        }
        while(q != null){
            lengthB++;
            q = q.next;
        }
        int tmpA = lengthA;
        while(lengthA > lengthB){
            headA = headA.next;
            lengthA--;
        }
        lengthA = tmpA;
        while(lengthA < lengthB){
            headB = headB.next;
            lengthB--;
        }
        while(headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
