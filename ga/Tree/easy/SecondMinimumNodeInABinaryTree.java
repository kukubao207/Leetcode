package Tree.easy;
//671. Second Minimum Node In a Binary Tree
//Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
//
//Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
//
//If no such second minimum value exists, output -1 instead.
//
//Example 1:
//
//Input:
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//Output: 5
//Explanation: The smallest value is 2, the second smallest value is 5.
//
//
//Example 2:
//
//Input:
//    2
//   / \
//  2   2
//
//Output: -1
//Explanation: The smallest value is 2, but there isn't any second smallest value.

import java.util.LinkedList;
import java.util.Queue;

//  2
//2  2
//2 2 3
public class SecondMinimumNodeInABinaryTree {
    //root.val = min(root.left.val, root.right.val)
    //最小的值一定是根节点
    //1.递归
    //时间复杂度O(n)
    int res = Integer.MAX_VALUE;
    int flag = 0;//因为测试用例中有最小值等于Integer.MAX_VALUE
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        find(root, root.val);
        if(res != Integer.MAX_VALUE || flag == 1)
            return res;
        else
            return -1;
    }
    public void find(TreeNode node, int val){
        if(node == null)
            return;
        if(node.val != val){//如果当前节点大于根节点的值，则比较（当前节点，递归左节点，递归右节点）
            res = Math.min(res, node.val);
            flag = 1;
        }
        else{//否则递归下去
            find(node.left, val);
            find(node.right, val);
        }
    }
    //2.迭代（层次遍历）
    //时间复杂度O(n)
    public int findSecondMinimumValue1(TreeNode root) {
        if(root == null)
            return  -1;
        int min = root.val;
        int secondMin = Integer.MAX_VALUE;
        int flag = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                TreeNode node = queue.poll();
                if(node.val <= secondMin && node.val > min){
                    secondMin = node.val;
                    flag = 1;
                }
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
        }
        if(flag == 1)
            return secondMin;
        return -1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
