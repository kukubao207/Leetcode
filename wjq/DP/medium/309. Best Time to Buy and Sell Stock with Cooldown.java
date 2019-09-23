309. Best Time to Buy and Sell Stock with Cooldown
        Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

        You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
        After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
        Example:

        Input: [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]

// 买卖股票的通用解法，三维DP
// dp[i][j][0] 表示第i天，至多j次交易，当前天不持有股票的最大利润
// dp[i][j][1] 表示第i天，至多j次交易，当前天持有股票的最大利润
// 状态转移方程：
// dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
// dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);

// 对于本题，每次 sell 之后要等一天才能继续交易。只要把这个特点融入之前的状态转移方程即可：
//
//        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//        dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
//        解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[][] dp = new int[prices.length][2];
        // 第0天持有，那么初始化profit为 -prices[0]
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}