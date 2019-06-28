package Tree.easy;

//226.Invert a binary tree.

//Example:
//Input:
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9

//Output:
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
public class InvertBinaryTree {
    //1.递归
    //利用先序遍历
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //2.利用后序遍历
    public TreeNode invertTree1(TreeNode root) {
        if(root == null)
            return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    //3.利用中序遍历
    public TreeNode invertTree2(TreeNode root) {
        if(root == null)
            return null;
        invertTree(root.left);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = rightNode;
        invertTree(root.left);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
