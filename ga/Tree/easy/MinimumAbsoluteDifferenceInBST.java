package Tree.easy;
//530. Minimum Absolute Difference in BST
//Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
//
//Example:
//
//Input:
//
//   1
//    \
//     3
//    /
//   2
//
//Output:
//1
//
//Explanation:
//The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
//
//
//Note: There are at least two nodes in this BST.
public class MinimumAbsoluteDifferenceInBST {
    //中序遍历
    //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
    //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
    int pre = 0;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        getMin(root);
        return result;
    }

    TreeNode preNode;
    int result = Integer.MAX_VALUE;
     public void getMin(TreeNode root){
         if(root == null)
             return;
         getMin(root.left);
         if(preNode != null){
             result = Math.min(Math.abs(preNode.val - root.val), result);
         }
         preNode = root;
         getMin(root.right);
     }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
