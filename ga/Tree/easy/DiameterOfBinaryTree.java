package Tree.easy;
//543. Diameter of Binary Tree
//Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//Example:
//Given a binary tree
//          1
//         / \
//        2   3
//       / \
//      4   5
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//Note: The length of path between two nodes is represented by the number of edges between them.
public class DiameterOfBinaryTree {
    //最大深度(从根节点到最远叶子节点的最长路径上的节点总数)
    //二叉树的 每个节点的左右子树的高度和 的最大值。
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return max;
    }
    int max = 0;
    public int getMaxDepth(TreeNode root){
        if(root == null)
            return 0;
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        if(leftDepth + rightDepth > max)
            max = leftDepth + rightDepth;
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
