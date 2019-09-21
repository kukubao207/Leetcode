package Offer;

//平衡二叉树
//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
public class BalancedBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        getDepth(root);
        return isBalance;
    }
    boolean isBalance = true;
    public int getDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) > 1)
            isBalance = false;
        return Math.max(left, right) + 1;
    }
}
