package Tree.medium;
//106. Construct Binary Tree from Inorder and Postorder Traversal
//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
//
//For example, given
//
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7106. Construct Binary Tree from Inorder and Postorder Traversal
//
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    //递归（先序/后序 + 中序可以唯一确定一颗二叉树）
    //中序的遍历顺序是，左中右
    //后序的遍历顺序是，左右中
    //与105不同就是，postorder的逆序遍历就是树的root.val,所以此处遍历postorder的方式就是逆序遍历数组，创建根节点 遇到的顺序是根，右，左
    int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd)
            return null;
        int val = postorder[index--];
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == val){
                TreeNode root = new TreeNode(val);
                root.right = helper(inorder, postorder, i + 1, inEnd);
                root.left = helper(inorder, postorder, inStart, i - 1);
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
