package Tree.easy;
//110. Balanced Binary Tree
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as:
//
//a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//Example 1:
//
//Given the following tree [3,9,20,null,null,15,7]:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Return true.
//
//Example 2:
//
//Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//Return false.
public class BalancedBinaryTree {
    //一个二叉树 每个节点的 左右两个子树的高度差的绝对值不超过1。
    //三个判断条件
    //1.左子树是平衡二叉树
    //2.右子树是平衡二叉树
    //3.左右子树高度不超过1
    public boolean isBalanced(TreeNode root) {
       if(root == null)
           return true;
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
