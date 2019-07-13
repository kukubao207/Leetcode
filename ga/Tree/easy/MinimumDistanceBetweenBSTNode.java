package Tree.easy;
//783. Minimum Distance Between BST Nodes
//Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
//
//Example :
//
//Input: root = [4,2,6,1,3,null,null]
//Output: 1
//Explanation:
//Note that root is a TreeNode object, not an array.
//
//The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
//
//          4
//        /   \
//      2      6
//     / \
//    1   3
//
//while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
//Note:
//
//The size of the BST will be between 2 and 100.
//The BST is always valid, each node's value is an integer, and each node's value is different.
public class MinimumDistanceBetweenBSTNode {
    //中序遍历
    //时间复杂度O(nlogn)
    int minPlus = Integer.MAX_VALUE;
    TreeNode pre;
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return -1;
        inOrder(root);
        return minPlus;
    }
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        if(pre != null)
            minPlus = Math.min(root.val - pre.val, minPlus);
        pre = root;
        inOrder(root.right);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
