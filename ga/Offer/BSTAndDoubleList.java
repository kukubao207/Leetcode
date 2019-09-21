package Offer;

/**二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BSTAndDoubleList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return node;
    }
    TreeNode pre = null;
    TreeNode node = null;
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        if(pre == null){
            node = root;
        }else{
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        inOrder(root.right);
    }
}
