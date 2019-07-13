package Tree.easy;

import java.util.LinkedList;
import java.util.Queue;

//700. Search in a Binary Search Tree
//Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
//
//For example,
//
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//And the value to search: 2
//You should return this subtree:
//
//      2
//     / \
//    1   3
//In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
//
//Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
public class SearchinaBinarySearchTree {
    //1.递归
    //时间复杂度O(nlogn)
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        else if(val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    //2.迭代
    //层次遍历//时间复杂度O(N)
    public TreeNode searchBST1(TreeNode root, int val) {
        TreeNode node = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                node = queue.poll();
                if(node.val == val)
                    return node;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count --;
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
