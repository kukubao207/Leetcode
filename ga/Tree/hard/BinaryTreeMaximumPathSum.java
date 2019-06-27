package Tree.hard;
//124. Binary Tree Maximum Path Sum
//Given a non-empty binary tree, find the maximum path sum.
//
//For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
//Example 1:
//
//Input: [1,2,3]
//
//       1
//      / \
//     2   3
//
//Output: 6
//Example 2:
//
//Input: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//Output: 42
public class BinaryTreeMaximumPathSum {
    //最大和路径的位置共有三种可能的情况：
    //1.在左子树中
    //2.在右子树中
    //3.包含当前根结点
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    public int getMax(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0, getMax(root.left));// 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(root.right));
        max = Math.max(max, left + right + root.val);// 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + root.val;//保证在一条线路上
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
