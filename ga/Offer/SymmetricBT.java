package Offer;

/**对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricBT {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetricalWithTwo(pRoot, pRoot);
    }
    public boolean isSymmetricalWithTwo(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        else if(root1 == null || root2 == null)
            return false;
        return root1.val == root2.val &&
                isSymmetricalWithTwo(root1.left, root2.right) &&
                isSymmetricalWithTwo(root1.right, root2.left);

    }
}
