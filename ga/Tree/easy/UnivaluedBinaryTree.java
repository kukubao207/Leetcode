package Tree.easy;
//965. Univalued Binary Tree
//A binary tree is univalued if every node in the tree has the same value.
//
//Return true if and only if the given tree is univalued.
//
//
//
//Example 1:
//
//
//Input: [1,1,1,1,1,null,1]
//Output: true
//Example 2:
//
//
//Input: [2,2,2,5,2]
//Output: false
//
//
//Note:
//
//The number of nodes in the given tree will be in the range [1, 100].
//Each node's value will be an integer in the range [0, 99].
public class UnivaluedBinaryTree {
    //1.中序遍历
    TreeNode pre = null;
    boolean res = true;
    public boolean isUnivalTree(TreeNode root) {
       helper(root);
        return res;
    }

    public void helper(TreeNode root){
        if(root != null){
            isUnivalTree(root.left);
            if(pre == null)
                pre = root;
            else{
                if(pre.val != root.val)
                    res = false;
            }
            isUnivalTree(root.right);
        }
    }

    //2.递归
    public boolean isUnivalTree1(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        if(root.left != null && root.left.val != root.val || root.right != null && root.right.val != root.val)
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
