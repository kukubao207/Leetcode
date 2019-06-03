package LinkedList.medium;

import java.util.ArrayList;
import java.util.List;

//109. 有序链表转换二叉搜索树
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//示例:
//
//给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
public class ConvertSortedListToBinarySearchTreeII {
    //1.借鉴第108题将有序数组转换为二叉搜索树的思想，先将有序链表转化为数组，再使用第108题的方法即可快速解决.
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        int[] nums = new int[length];
        int i = 0;
        while(head != null){
            nums[i++] = head.val;
            head = head.next;
        }
        if(nums == null)
            return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int l, int r) {
        if(r < l)
            return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }

    //2.找链表的中间结点:快慢指针法
    //定义一个快指针fast 一个慢指针slow
    // 快指针一次移动两个结点，慢指针一次移动一个结点
    // 当fast到达链表的尾部结点时，慢指针也就移动到了链表的中间结点 （同化成一个路程问题，同一段路程，A的速度是B的两倍，他们同时出发，当A走完全程时，B也就刚好走过一半） 中间结点找到了，其他的也就类似了
    public TreeNode sortedListToBST1(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        return buildTree1(head, null);

    }
    public TreeNode buildTree1(ListNode head, ListNode tail) {
        if(head == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while( fast.next != tail && fast.next.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree1(head, slow);
        root.right = buildTree1(slow.next, tail);
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
