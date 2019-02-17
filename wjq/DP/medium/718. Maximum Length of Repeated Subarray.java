718. Maximum Length of Repeated Subarray

        Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

        Example 1:
        Input:
        A: [1,2,3,2,1]
        B: [3,2,1,4,7]
        Output: 3
        Explanation:
        The repeated subarray with maximum length is [3, 2, 1].
        Note:
        1 <= len(A), len(B) <= 1000
        0 <= A[i], B[i] < 100

解题思路
dp[i][j]表示的是以A[i],B[j]作为结尾的公共子串的最大长度
所以递推关系
d[i+1][j+1]=dp[i][j]+1;

初始化条件
dp[k][0]=0 (0<=k<=A.length)
dp[0][k]=0 (0<=k<=B.length)


class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i=0;i<A.length+1;i++)
            dp[i][0]=0;
        for(int i=0;i<B.length+1;i++)
            dp[0][i]=0;
        int res = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    res = Math.max(dp[i+1][j+1],res);
                }
            }
        }
        return res;
    }
}