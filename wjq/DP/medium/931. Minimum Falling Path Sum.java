931. Minimum Falling Path Sum


        Given a square array of integers A, we want the minimum sum of a falling path through A.

        A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.



        Example 1:

        Input: [[1,2,3],[4,5,6],[7,8,9]]
        Output: 12
        Explanation:
        The possible falling paths are:
        [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
        [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
        [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
        The falling path with the smallest sum is [1,4,7], so the answer is 12.



        Note:

        1 <= A.length == A[0].length <= 100
        -100 <= A[i][j] <= 100


我的思路
在不改变原始数组的情况下，时间复杂度O(mn)空间复杂度O(n)
如果改变原始数组，可以做到时间复杂度O(mn)空间复杂度O(1)
class Solution {
    public int minFallingPathSum(int[][] A) {
        int[] lastLevel = new int[A[0].length];
        for(int i=0;i<A[0].length;i++)
            lastLevel[i] = A[0][i];

        for(int i=1;i<A.length;i++){
            int[] curLevel = new int[A[0].length];
            for(int j=0;j<A[0].length;j++){
                int pre=Math.max(j-1,0),cur=j,next=Math.min(j+1,A[i].length-1);
                curLevel[j] = Math.min(Math.min(lastLevel[pre],lastLevel[cur]),lastLevel[next]) + A[i][j];
            }
            lastLevel = curLevel;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<A[0].length;i++)
            res = Math.min(res,lastLevel[i]);
        return res;
    }
}