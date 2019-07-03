package Tree.easy;
//404. Sum of Left Leaves
//Find the sum of all left leaves in a given binary tree.
//
//Example:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
public class SumOfLeftLeaves {
    //1.递归（先序）
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode root, boolean left) {//boolean left标记是否为左子树
        if(root == null)
            return sum;
        if(left && root.left == null && root.right == null)
            sum = sum + root.val;
        dfs(root.left, true);
        dfs(root.right, false);
        return sum;
    }

    //2.层次遍历，判断是否叶子节点即可（不写了）

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
