package Array.medium;
//74. 搜索二维矩阵
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//每行中的整数从左到右按升序排列。
//每行的第一个整数大于前一行的最后一个整数。
//示例 1:
//
//输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//示例 2:
//
//输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false
public class SearchA2DMatrix {
    //类似二分法
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return searchMatrix(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean searchMatrix (int [][]matrix, int target, int startIndex, int endIndex) {
        while(startIndex <= endIndex){
            int mid = (startIndex + endIndex) / 2;
            int row = mid / matrix[0].length;
            int col = mid - row * matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (target > matrix[row][col]) {
                return searchMatrix(matrix, target, mid + 1, endIndex);
            } else {
                return searchMatrix(matrix, target, startIndex, mid -1);
            }
        }
        return false;
    }
//选择右上角或者左下角进行比较
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] < target)
                row++;
            else if(matrix[row][col] > target)
                col--;
            else
                return true;
        }
        return false;
    }
}
