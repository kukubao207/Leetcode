59. Spiral Matrix II

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]


我的思路
就是模拟构造这样一个矩阵的过程。
想清楚转弯的判断条件。
遇到边界或者遇到已经填过的空格，就要转弯。
class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int curx = 0, cury = 0, curDirection = 0;
        int [][]pos = {{0,1},{1,0},{0,-1},{-1,0}};
        int [][]result = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                result[i][j]=0;
        while(num<=n*n) {
            result[curx][cury]=num;
            int nextx = curx+pos[curDirection][0];
            int nexty = cury+pos[curDirection][1];
            //如果下一个位置不在边界内，或者已经访问过
            if(!(nextx>=0&&nextx<n&&nexty>=0&&nexty<n)||result[nextx][nexty]!=0){
                curDirection = (curDirection+1)%4;
                nextx = curx+pos[curDirection][0];
                nexty = cury+pos[curDirection][1];
            }
            curx=nextx;
            cury=nexty;
            num++;
        }
        return result;
    }
}

别人的思路
public static int[][] generateMatrix(int n) {
    int[][] ret = new int[n][n];
    int left = 0,top = 0;
    int right = n -1,down = n - 1;
    int count = 1;
    while (left <= right) {
        for (int j = left; j <= right; j ++) {
            ret[top][j] = count++;
        }
        top ++;
        for (int i = top; i <= down; i ++) {
            ret[i][right] = count ++;
        }
        right --;
        for (int j = right; j >= left; j --) {
            ret[down][j] = count ++;
        }
        down --;
        for (int i = down; i >= top; i --) {
            ret[i][left] = count ++;
        }
        left ++;
    }
    return ret;
}