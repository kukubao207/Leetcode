Say you have an array for which the ith element is the price of a given stock on day i.

        If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

        Note that you cannot sell a stock before you buy one.

        Example 1:

        Input: [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Not 7-1 = 6, as selling price needs to be larger than buying price.
        Example 2:

        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.


// 买卖股票的通用解法，三维DP
// dp[i][j][0] 表示第i天，至多j次交易，当前天不持有股票的最大利润
// dp[i][j][1] 表示第i天，至多j次交易，当前天持有股票的最大利润
// 状态转移方程：
// dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
// dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);

// 令 j = 1
// 优化后的状态转移方程
// dp[i][j][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
// dp[i][j][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
// 因为dp[i][0][0] = 0(至多0次交易)

// 所以可以降维解决, 最终状态转移方程为：
// dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
// dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}