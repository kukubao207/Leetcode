package Array.medium;

import java.util.Arrays;

//48. 旋转图像
//给定一个 n × n 的二维矩阵表示一个图像。
//
//将图像顺时针旋转 90 度。
//
//说明：
//
//你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
//示例 1:
//
//给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//示例 2:
//
//给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
public class RotateImage {
    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.println(matrix[i][j]);
            }
        }

    }
    //每次对4个数进行交换
    public static void rotate(int[][] matrix) {
//        int n = matrix.length % 2 == 0 ? matrix.length / 2 : matrix.length / 2 + 1;
        int n = matrix.length / 2;
        for(int i = 0; i < n; i++){
            for(int j = i; j < matrix.length - 1 - i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = tmp;
            }
        }
    }
}
