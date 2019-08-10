package Stack.hard;
import java.util.Stack;

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
        //1.利用84题， 对每一行都求出每个元素对应的高度，这个高度就是对应的连续1的长度
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length,n = matrix[0].length;
        int[] heights = new int[n];
        int res = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                heights[j] = matrix[i][j]== '0' ? 0 : 1 + heights[j];
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;

//        int maxRec = 0;
//        if (matrix.length == 0 || matrix == null)
//            return maxRec;
//        int dp[][] = new int[matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == '1') {
//                    if (i == 0 || dp[i - 1][j] == 0)
//                        dp[i][j] = 1;
//                    else
//                        dp[i][j] = dp[i - 1][j] + 1;
//                } else
//                    dp[i][j] = 0;
//            }
//            maxRec = Math.max(maxRec, largestRectangleArea(dp[i]));
//        }
//        return maxRec;
    }

    public static int largestRectangleArea(int[] heights) {
        int[] heightn = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
        heightn[heights.length] = 0;   //最后增加个高度为0的柱子，以便把单调栈里面的都弹出去。
        Stack<Integer> stack = new Stack<>(); //存储序号
        int maxS = 0;
        for (int i = 0; i < heightn.length; i++) {
            while (!stack.isEmpty() && heightn[i] < heightn[stack.peek()]){  //一直出栈 直到遇见小的
                int temp = stack.pop();
                maxS = Math.max(maxS, ((stack.isEmpty() ? i : (i - stack.peek() - 1) ) * heights[temp]));//求包含heights[tmo]的面积
            }
            stack.push(i);//递增push
        }
        return maxS;
    }

}
