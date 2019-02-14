54. Spiral Matrix

        Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

        Example 1:

        Input:
        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]
        Output: [1,2,3,6,9,8,7,4,5]
        Example 2:

        Input:
        [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9,10,11,12]
        ]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]

题意
给一个m*n矩阵，顺时针输出

题解
循环，每次输出一个圈
第i个圈的起始位置一定是(i-1,i-1)
输出一个圈，只要找到圈的右边界和下边界就可以。
注意存在最后一个圈退化成一个值、一条横线、一条竖线、两条横线等情况。


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0)
            return res;
        int n=matrix.length*matrix[0].length;
        int row=matrix.length,column=matrix[0].length;
        int circle_num=0;
        while(n>0){
            int endX = column - circle_num - 1;
            int endY = row - circle_num - 1;
            for(int i=circle_num;i<=endX&&n>0;i++){
                res.add(matrix[circle_num][i]);
                n--;
            }
            if(circle_num+1<=endY){
                for(int i=circle_num+1;i<=endY&&n>0;i++){
                    res.add(matrix[i][endX]);
                    n--;
                }
            }
            if(endX-1>=circle_num){
                for(int i=endX-1;i>=circle_num&&n>0;i--){
                    res.add(matrix[endY][i]);
                    n--;
                }
            }
            if(endY-1>circle_num){
                for(int i=endY-1;i>circle_num&&n>0;i--){
                    res.add(matrix[i][circle_num]);
                    n--;
                }
            }
            circle_num++;
        }
        return res;
    }
}

一种更优雅的方式
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0)
            return res;

        int rowBegin=0,rowEnd=matrix.length-1;
        int columnBegin=0,columnEnd=matrix[0].length-1;
        while(rowBegin<=rowEnd&&columnBegin<=columnEnd){
            for(int i=columnBegin;i<=columnEnd;i++)
                res.add(matrix[rowBegin][i]);
            rowBegin++;
            for(int i=rowBegin;i<=rowEnd;i++)
                res.add(matrix[i][columnEnd]);
            columnEnd--;
            //确保有两行以上
            if(rowBegin<=rowEnd){
                for(int i=columnEnd;i>=columnBegin;i--)
                    res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            //确保有三列以上
            if(columnBegin<=columnEnd){
                for(int i=rowEnd;i>=rowBegin;i--)
                    res.add(matrix[i][columnBegin]);
            }
            columnBegin++;
        }
        return res;
    }
}