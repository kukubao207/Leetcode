package Array.medium;

import java.util.Arrays;

//59. 螺旋矩阵 II
//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
//示例:
//
//输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
//🌝 这道题和上一道差不多，甚至更简单了，所以这个题不算啦，你再做两个贪心的题，我放在Greedy下面
public class SpiralMatrix_II {
    public static void main(String args[]){
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++)
                System.out.println(matrix[i][j]);
        }

    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int j = 0;
        int num = 1;
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        do {
            a = false;
            b = false;
            c = false;
            d = false;
            for (int i = j; i < n - j; i++) {
                matrix[j][i] = num;
                num = num + 1;
                a = true;
            }
            if (a) {
                for (int i = j + 1; i < n - j; i++) {
                    matrix[i][n - j - 1] = num;
                    num = num + 1;
                    b = true;
                }
            }
            if (b) {
                for (int i = n - j - 2; i >= j; i--) {
                    matrix[n - j - 1][i] = num;
                    num = num + 1;
                    c = true;
                }
            }
            if (c) {
                for (int i = n - j - 2; i >= j + 1; i--) {
                    matrix[i][j] = num;
                    num = num + 1;
                    d = true;
                }
            }
            j++;
//        }while(num == n * n + 1);//这个终止条件不行
        }while(a & b & c & d);
    return matrix;
    }

}
