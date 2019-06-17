package Tree.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//104. Maximum Depth of Binary Tree
//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its depth = 3.
public class MaximumDepthOfBinaryTree {
    //递归
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    //迭代
    public int maxDepth1(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int preCount = 1;//记录前一层的节点数
        int count = 0;//记录当前的节点数
        int depth = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            preCount--;
            if(node.left != null){
                queue.add(node.left);
                count++;
            }
            if(node.right != null) {
                queue.add(node.right);
                count++;
            }
            if(preCount == 0){
                preCount = count;
                count = 0;
                depth++;
            }
        }
        return depth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
