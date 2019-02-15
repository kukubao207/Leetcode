73. Set Matrix Zeroes
        Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

        Example 1:

        Input:
        [
        [1,1,1],
        [1,0,1],
        [1,1,1]
        ]
        Output:
        [
        [1,0,1],
        [0,0,0],
        [1,0,1]
        ]

        Example 2:

        Input:
        [
        [0,1,2,0],
        [3,4,5,2],
        [1,3,1,5]
        ]
        Output:
        [
        [0,0,0,0],
        [0,4,5,0],
        [0,3,1,0]
        ]
        Follow up:

        A straight forward solution using O(mn) space is probably a bad idea.
        A simple improvement uses O(m + n) space, but still not the best solution.
        Could you devise a constant space solution?


用第一行和第一列来标记第i行或第i列是否应该全被标为0
第一行和第一列就用f1和f2两个boolean来标记是否应该全被标为0
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean f1=false,f2=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0)
                        f1=true;
                    if(j==0)
                        f2=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(f1==true)
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i]=0;
        if(f2==true)
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;

    }

}