package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

//958. Check Completeness of a Binary Tree
//Given a binary tree, determine if it is a complete binary tree.
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//
//
//Example 1:
//
//
//
//Input: [1,2,3,4,5,6]
//Output: true
//Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
//Example 2:
//
//
//
//Input: [1,2,3,4,5,null,7]
//Output: false
//Explanation: The node with value 7 isn't as far left as possible.
//
//Note:
//
//The tree will have between 1 and 100 nodes.
public class CheckCompletenessofaBinaryTree {
    //层次遍历
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                TreeNode node = queue.poll();
                //出现第一个null节点，记录。如果出现null节点后还出现了非Null节点，表示节点不是全部都靠左，返回false
                if(node == null && !flag)
                    flag = true;
                else if(node != null && flag){
                    return false;
                }else if(node != null && !flag){
                    queue.add(node.left);
                    queue.add(node.right);
                }
                count--;
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
