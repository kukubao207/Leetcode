714. Best Time to Buy and Sell Stock with Transaction Fee

        Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

        You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

        Return the maximum profit you can make.

        Example 1:
        Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
        Output: 8
        Explanation: The maximum profit can be achieved by:
        Buying at prices[0] = 1
        Selling at prices[3] = 8
        Buying at prices[4] = 4
        Selling at prices[5] = 9
        The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
        Note:

        0 < prices.length <= 50000.
        0 < prices[i] < 50000.
        0 <= fee < 50000.

// 买卖股票的通用解法，三维DP
// dp[i][j][0] 表示第i天，至多j次交易，当前天不持有股票的最大利润
// dp[i][j][1] 表示第i天，至多j次交易，当前天持有股票的最大利润
// 状态转移方程：
// dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
// dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);

// 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
// dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
// dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

// 对于本题，只需要在卖出的时候减去手续费就可以了

// dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
// dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }
}