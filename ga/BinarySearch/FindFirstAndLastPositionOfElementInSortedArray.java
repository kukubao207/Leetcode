package BinarySearch;

import java.util.ArrayList;
import java.util.List;

//34. Find First and Last Position of Element in Sorted Array
/*
* 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
* */



public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    /*
    * 大致分为四步，分别是：
    * 1.从第一行第一个到第一行最后一个；
    * 2.从第二行最后一个到最后一行最后一个；
    * 3.从最后一行倒数第二个到最后一行第一个；
    * 4.从倒数第二行第一个到第二行第一个；
    * 这就算是顺时针最外围的一个循环，然后后面的跟前面的是类似的不过循环的行和列都加1
    *
    * */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length ==0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;//数组的行
        int n = matrix[0].length;//数组的列
        int j = 0;
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        do{
            a = false;
            b = false;
            c = false;
            d = false;
            for(int i = j; i < n - j; i++){
                res.add(matrix[j][i]);
                a = true;
            }
            if(a){
            for(int i = j + 1; i < m - j; i++){
                res.add(matrix[i][n - j - 1]);
                b = true;
            }}
            if(b){
            for(int i = n - j - 2; i >= j; i--){
                res.add(matrix[m - j - 1][i]);
                System.out.println(m - j - 1);
                c = true;
            }}
            if(c){
            for(int i = m - j - 2; i >= j + 1; i--){
                res.add(matrix[i][j]);
                d = true;
            }}
            j++;
        }while(a & b & c & d);//判断四个步骤是否被执行，如果没有被执行就说明矩阵的值已经传输完毕
        return res;
    }
}
