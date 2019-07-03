package Tree.medium;
//337. House Robber III
//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//Determine the maximum amount of money the thief can rob tonight without alerting the police.
//
//Example 1:
//
//Input: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \
//     3   1
//
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//Example 2:
//
//Input: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
//
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
public class HouseRobber_III {
    //1.能盗取的最高金额为 抢劫该节点+抢劫该节点的左孩子的左右子树+抢劫该节点的右孩子的左右子树
    //与 抢劫该节点的左子树+抢劫该节点的右子树的和的最大值
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int val = 0;
        if(root.left != null)
            val = val + rob(root.left.left) + rob(root.left.right);
        if(root.right != null)
            val = val + rob(root.right.left) + rob(root.right.right);
        return Math.max(root.val + val, rob(root.left) + rob(root.right));
    }
    //2.动态规划
    //定义一个数组res,长度为2,res[0]表示不抢该节点可获得最大值,res[1]表示抢劫该节点可获得最大值
    //方法helper(r)意为：在以r为根节点的树中,返回抢劫根节点与不抢劫根节点可获得的最大值

    public int rob1(TreeNode root){
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode r){
        if(r == null)
            return new int[2];
        int[] left = helper(r.left);//对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额. left[0]则为不抢r.lrft可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额  以下right[] 分析同理
        int[] right = helper(r.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);//计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[1] = r.val + left[0] + right[0];//计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
