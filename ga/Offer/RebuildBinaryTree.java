package Offer;

public class RebuildBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null)
            return null;
        return helper(pre, in, 0, in.length - 1);
    }

    int preIndex = 0;

    public TreeNode helper(int[] pre, int[] in, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (pre[preIndex] == in[i]) {
                preIndex++;
                TreeNode root = new TreeNode(in[i]);
                root.left = helper(pre, in, inStart, i - 1);
                root.right = helper(pre, in, i + 1, inEnd);
                return root;
            }
        }
        return null;
    }
}