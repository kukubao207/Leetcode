package Tree.medium;
//105. Construct Binary Tree from Preorder and Inorder Traversal
//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
//
//For example, given
//
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //递归
    //前序的遍历顺序是，中左右
    //中序的遍历顺序是，左中右
    //1.以前序建立索引，一个一个拿出来，首先拿出第一个数a，然后找到中序里a的位置
    //2.中序里面a左边的就是左子树，a右边的就是右子树，递归调用就行了
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(inStart > inEnd)
            return null;
        int val = preorder[index++];//找到根节点
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == val){
                TreeNode root = new TreeNode(val);
                root.left = helper(preorder, inorder, inStart, i - 1);
                root.right = helper(preorder, inorder, i + 1, inEnd);
                return root;
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
