120. Triangle

        Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

        For example, given the following triangle

        [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
        ]
        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

        Note:

        Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


时间复杂度O(row*row)  空间复杂度O(row*row)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        dp[0][0]=triangle.get(0).get(0);
        if(row==0)
            return 0;
        else if(row==1)
            return dp[0][0];

        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
            for(int j=1;j<i;j++){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<dp[row-1].length;i++)
            if(dp[row-1][i]<ans)
                ans = dp[row-1][i];
        return ans;
    }
}

时间O(row*row) 空间O(row)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if(row==0)
            return 0;
        else if(row==1)
            return triangle.get(0).get(0);
        int[] dp = new int[row];
        dp[0]=triangle.get(0).get(0);
        for(int i=1;i<row;i++){
            dp[i]=dp[i-1]+triangle.get(i).get(i);
            for(int j=i-1;j>0;j--){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j-1],dp[j]);
            }
            dp[0]=dp[0]+triangle.get(i).get(0);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++)
            if(dp[i]<ans)
                ans = dp[i];
        return ans;
    }
}