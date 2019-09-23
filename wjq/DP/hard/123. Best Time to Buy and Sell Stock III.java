123. Best Time to Buy and Sell Stock III
        Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete at most two transactions.

        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

        Example 1:

        Input: [3,3,5,0,0,3,1,4]
        Output: 6
        Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
        Example 2:

        Input: [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
        engaging multiple transactions at the same time. You must sell before buying again.
        Example 3:

        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.

// 买卖股票的通用解法，三维DP
// dp[i][j][0] 表示第i天，至多j次交易，当前天不持有股票的最大利润
// dp[i][j][1] 表示第i天，至多j次交易，当前天持有股票的最大利润
// 状态转移方程：
// dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
// dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);

//

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][][] dp = new int[prices.length][3][2];
        // 第0天持有，那么初始化profit为 -prices[0]
        for (int i = 1; i < 3; i++)
            dp[0][i][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for(int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][2][0];
    }
}