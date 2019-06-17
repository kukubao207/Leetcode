package Tree.medium;

import java.util.Stack;

//98. Validate Binary Search Tree
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//
//
//Example 1:
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//Example 2:
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
public class ValidateBinarySearchTree {
    //[10,5,15,null,null,6,20]
//    public boolean isValidBST(TreeNode root) {
//        if(root == null)
//            return true;
//        if(root.left == null && root.right == null)
//            return true;
//        else if(root.left == null)
//            return root.val < root.right.val && isValidBST(root.right);
//        else if(root.right == null)
//            return root.val > root.left.val && isValidBST(root.left);
//        return root.val > root.left.val && root.val < root.right.val && isValidBST(root.left) && isValidBST(root.right);
//    }

    //利用 二叉搜索树 中序遍历的有序性，只需在遍历的过程中判断当前节点是否大于前一个节点即可
    long pre = Long.MIN_VALUE;//要放在外面  不然每次迭代被覆盖
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(isValidBST(root.left)){
            if(root.val > pre){
                pre = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    //迭代的中序遍历
    public boolean isValidBST1(TreeNode root) {
        long pre = Long.MIN_VALUE;
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                if(cur.val <= pre)
                    return false;
                pre = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
