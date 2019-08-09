package Stack.hard;
import static Stack.hard.LargestRectangleinHistogram.largestRectangleArea;

//85. Maximal Rectangle
//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
//Example:
//
//Input:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//Output: 6
public class MaximalRectangle {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        char[][] m = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(m));
    }

    public static int maximalRectangle(char[][] matrix) {
        int maxRec = 0;
        if (matrix.length == 0 || matrix == null)
            return maxRec;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || dp[i - 1][j] == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j] + 1;
                } else
                    dp[i][j] = 0;
            }
            maxRec = Math.max(maxRec, largestRectangleArea(dp[i]));
        }
        return maxRec;
    }
}
