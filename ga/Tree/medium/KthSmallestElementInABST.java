package Tree.medium;

//230.Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

//Note:
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

//Example 1:
//Input: root = [3,1,4,null,2], k = 1
//    3
//  / \
// 1   4
// \
//  2
//Output: 1

//Example 2:
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//Output: 3

import java.util.ArrayList;
import java.util.List;

//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
public class KthSmallestElementInABST {
    //1.中序遍历，存放至数组
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        return nums.get(k - 1);
    }

    public void dfs(TreeNode root, List<Integer> nums){
        if(root == null)
            return;
        if(root.left != null)
            dfs(root.left, nums);
        nums.add(root.val);
        if(root.right != null)
            dfs(root.right, nums);
    }

    //2.中序遍历，不需要全局遍历
    //在整个遍历过程中需要保存遍历到了第几个(mark)，如果为第K个，则可以返回该值
    public int kthSmallest1(TreeNode root, int k) {
        return helper(root, k);
    }
    int mark = 0;
    public Integer helper(TreeNode root, int k){
        if(root == null)
            return null;
        Integer left = helper(root.left, k);
        if(left != null)
            return left;
        mark++;
        if(mark == k)
            return root.val;
        Integer right = helper(root.right, k);
        if(right != null)
            return right;
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

