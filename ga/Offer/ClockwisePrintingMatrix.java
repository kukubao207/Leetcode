package Offer;

import java.util.ArrayList;

/**顺时针打印矩阵
 *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockwisePrintingMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null)
            return res;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i <= colEnd; i++){
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            for(int i = rowStart; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowEnd >= rowStart){
                for(int i = colEnd; i >= colStart; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(colEnd >= colStart){
                for(int i = rowEnd; i >= rowStart; i--){
                    res.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return res;
    }
}
