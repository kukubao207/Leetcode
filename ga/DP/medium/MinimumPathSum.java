package DP.medium;
//64. 最小路径和
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
//
//示例:
//
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int sum = 0;
        for(int i = 0; i < m; i++){
            sum = sum + grid[i][0];
            res[i][0] = sum;
        }
        sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + grid[0][i];
            res[0][i] = sum;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                res[i][j] = Math.min(res[i - 1][j] + grid[i][j], res[i][j - 1] + grid[i][j]);
            }
        }
        return res[m - 1][n - 1];
    }
}
