A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28

我的思路
这道题是一道基础DP题
由于机器人只能往右边或者下边走，
所以对于某个格子，到达该格子的路径和为上面一个格子的路径和 + 左边一个格子的路径和
dp[i][j] = dp[i-1][j] + dp[i][j-1]

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0]=0;
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int i=0;i<n;i++)
            dp[0][i]=1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        return dp[m-1][n-1];
    }
}