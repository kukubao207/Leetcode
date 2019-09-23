188. Best Time to Buy and Sell Stock IV
        Hard

        908

        59

        Favorite

        Share
        Say you have an array for which the i-th element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete at most k transactions.

        Note:
        You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

        Example 1:

        Input: [2,4,1], k = 2
        Output: 2
        Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
        Example 2:

        Input: [3,2,6,5,0,3], k = 2
        Output: 7
        Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
        Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

// 买卖股票的通用解法，三维DP
// dp[i][j][0] 表示第i天，至多j次交易，当前天不持有股票的最大利润
// dp[i][j][1] 表示第i天，至多j次交易，当前天持有股票的最大利润
// 状态转移方程：
// dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
// dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
// 初始化：
// 第0天若持有股票的话，最大利润应该为-prices[0]
// for (int i = 1; i < k + 1; i++)
//     dp[0][i][1] = -prices[0];
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2)
            return quickSolve(prices);
        int[][][] dp = new int[prices.length][k + 1][2];
        // 第0天持有，那么初始化profit为 -prices[0]
        for (int i = 1; i < k + 1; i++)
            dp[0][i][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for(int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }
    public int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] - prices[i - 1] > 0)
                profit += prices[i] - prices[i - 1];
        return profit;
    }
}