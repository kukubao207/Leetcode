74. Search a 2D Matrix
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
        Example 1:

        Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 3
        Output: true
        Example 2:

        Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 13
        Output: false

我的思路
二分查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int left=0,right=matrix.length*matrix[0].length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int x=mid/matrix[0].length,y=mid%matrix[0].length;
            if(matrix[x][y]<target)
                left = mid+1;
            else if(matrix[x][y]>target)
                right = mid-1;
            else
                return true;
        }
        return false;
    }
}