63. Unique Paths II
        A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

        Now consider if some obstacles are added to the grids. How many unique paths would there be?

        An obstacle and empty space is marked as 1 and 0 respectively in the grid.

        Note: m and n will be at most 100.

        Example 1:

        Input:
        [
        [0,0,0],
        [0,1,0],
        [0,0,0]
        ]
        Output: 2
        Explanation:
        There is one obstacle in the middle of the 3x3 grid above.
        There are two ways to reach the bottom-right corner:
        1. Right -> Right -> Down -> Down
        2. Down -> Down -> Right -> Right

我的思路
深搜，TLE。
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int result = dfs(0,0,obstacleGrid);
        return result;
    }
    public static int dfs(int i,int j,int[][] ob){
        if(i>=ob.length||j>=ob[0].length||ob[i][j]==1)
            return 0;
        if(i==ob.length-1&&j==ob[0].length-1){
            return 1;
        }
        return dfs(i+1,j,ob) + dfs(i,j+1,ob);
    }
}
DP
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int result = 0;
        for(int i=0;i<dp.length;i++){
            if(obstacleGrid[i][0]==1)
                break;
            dp[i][0]=1;
        }

        for(int i=0;i<dp[0].length;i++){
            if(obstacleGrid[0][i]==1)
                break;
            dp[0][i]=1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
