package Array.medium;

import java.util.ArrayList;
import java.util.List;

//73. 矩阵置零
//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//
//示例 1:
//
//输入:
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出:
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//示例 2:
//
//输入:
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出:
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//进阶:
//
//一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
//一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
//你能想出一个常数空间的解决方案吗？
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
    //空间复杂度O(n)
    public static int[][] setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> col = new ArrayList<Integer>();
        boolean judge = false;
        for(int i = 0; i < m; i++){
            judge = false;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    judge = true;
                    if(!col.contains(j))
                        col.add(j);
                }
            }
            if(judge){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int c : col){
            for(int i = 0; i < m; i++){
                matrix[i][c] = 0;
            }
        }
        return matrix;
    }



    //利用数组的首行和首列来记录 0 值。从数组下标的 A[1][1] 开始遍历，
    // 两个布尔值记录首行首列是否需要置0
    //空复杂度O(2)
    public void setZeroes1(int[][] matrix) {
        boolean rowFlag = false;
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }
        boolean colFlag = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                colFlag = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(rowFlag){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if(colFlag){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
