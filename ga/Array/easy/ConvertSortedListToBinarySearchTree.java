package Array.easy;
//108. 将有序数组转换为二叉搜索树
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//示例:
//
//给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//  /   /
//-10  5
public class ConvertSortedListToBinarySearchTree {
    //取数组的中间元素作为根结点， 将数组分成左右两部分，对数组的两部分用递归的方法分别构建左右子树。
    // 剩下的就是用动态规划方法解决了
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)
            return null;
        return buildTree(nums, 0, nums.length - 1);
    }
    public TreeNode buildTree(int[] nums, int l, int r) {
        if(r < l)
            return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

