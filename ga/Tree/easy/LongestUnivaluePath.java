package Tree.easy;
//687. Longest Univalue Path
//Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
//
//The length of path between two nodes is represented by the number of edges between them.
//
//
//
//Example 1:
//
//Input:
//
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//Output: 2
//
//
//
//Example 2:
//
//Input:
//
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
//Output: 2
//
//
//
//Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
public class LongestUnivaluePath {
    //递归
    int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        getMaxPath(root, root.val);
        return maxPath;
    }
    //以每个点为值得最长路径
    public int getMaxPath(TreeNode root, int val){
        if(root == null)
            return 0;
        int left = getMaxPath(root.left, root.val);
        int right = getMaxPath(root.right, root.val);
        maxPath = Math.max(maxPath, left + right);
        if(root.val == val)// 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
            return Math.max(left, right) + 1;
        return 0;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
