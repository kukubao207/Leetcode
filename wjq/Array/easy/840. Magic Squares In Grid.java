A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column,
and both diagonals all have the same sum.

Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).

Input: [[4,3,8,4],
[9,5,1,9],
[2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15

我的代码
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0,row=grid.length,column=grid[0].length;
        for(int i=0;i+3<=row;i++){
            for(int j=0;j+3<=column;j++){
                if(!(isNum(grid[i][j])&&isNum(grid[i][j+1])&&isNum(grid[i][j+2])
                        &&isNum(grid[i+1][j])&&isNum(grid[i+1][j+1])&&isNum(grid[i+1][j+2])
                        &&isNum(grid[i+2][j])&&isNum(grid[i+2][j+1])&&isNum(grid[i+2][j+2])))
                    continue;
                int row1=grid[i][j]+grid[i][j+1]+grid[i][j+2];
                int row2=grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
                int row3=grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
                int column1=grid[i][j]+grid[i+1][j]+grid[i+2][j];
                int column2=grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
                int column3=grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
                int diagonal1=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
                int diagonal2=grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
                if(row1==row2&&row2==row3&&row3==column1&&column1==column2&&column2==column3&&column3==diagonal1&&diagonal1==diagonal2)
                    count++;
            }
        }
        return count;
    }
    boolean isNum(int num){
        if(num>=1&&num<=9)
            return true;
        else
            return false;
    }
}

别人的代码
我没注意到的两个细节:
方块中间那个数一定是5
public int numMagicSquaresInside(int[][] grid) {
    int cnt=0;
    for(int i=0;i<=grid.length-3;i++)
    for(int j=0;j<=grid[0].length-3;j++)
    if(helper(i,j,grid)) cnt++;

    return cnt;
}

private boolean helper(int x,int y,int[][] grid){
    if(grid[x+1][y+1]!=5) return false;

    int[] valid=new int[16];

    for(int i=x;i<=x+2;i++)
    for(int j=y;j<=y+2;j++)
    valid[grid[i][j]]++;

    for (int v = 1; v <= 9; v++)
    if (valid[v] != 1) return false;

    if((grid[x][y]+grid[x][y+1]+grid[x][y+2])!=15)         return false;
    if((grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2])!=15)     return false;
    if((grid[x][y]+grid[x+1][y]+grid[x+2][y])!=15)         return false;
    if((grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2])!=15)   return false;
    if((grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2])!=15)   return false;
    if((grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y])!=15)     return false;
    return true;
}