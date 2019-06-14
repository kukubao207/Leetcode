package Tree.medium;
// 96. 不同的二叉搜索树
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
//示例:
//
//输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//

public class UniqueBinarySearchTrees {
    //动态规划
    //二叉搜索树——左子树<根节点<右子树
    //假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
    //G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)

    //当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
    //f(i) = G(i-1)*G(n-i)

    //代入得到 卡特兰数 公式
    //G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            for(int j = 0; j <= i - 1; j++)
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
        return dp[n];
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
