122. Best Time to Buy and Sell Stock II
        Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

        Example 1:

        Input: [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
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

//如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
//
//dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
//dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
//
//我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
//dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}