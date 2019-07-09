package Tree.easy;

import java.util.HashSet;

//653. Two Sum IV - Input is a BST
//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//Example 1:
//
//Input:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//Output: True
//
//
//Example 2:
//
//Input:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//Output: False
public class TwoSumIV_InputIsABST {
    //遍历二叉树+HashSet
    //时间复杂度O(n)
    //空间复杂度O(n)
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return preOrder(root, set, k);
    }
    public boolean preOrder(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)
            return false;
        if(set.contains(k - root.val))
            return true;
        set.add(root.val);
        return preOrder(root.left, set, k) || preOrder(root.right, set, k);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
