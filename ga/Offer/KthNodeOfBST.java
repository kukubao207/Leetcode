package Offer;

/**二叉树搜索树的第k个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNodeOfBST {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null)
            return null;
        TreeNode left = KthNode(pRoot.left, k);
        if(left != null)
            return left;
        count++;
        if(count == k)
            return pRoot;
        TreeNode right = KthNode(pRoot.right, k);
        if(right != null)
            return right;
        return null;
    }
}
