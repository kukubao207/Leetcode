52. N-Queens II
        The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

        Given an integer n, return the number of distinct solutions to the n-queens puzzle.

        Example:

        Input: 4
        Output: 2
        Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
        [
        [".Q..",  // Solution 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // Solution 2
        "Q...",
        "...Q",
        ".Q.."]
        ]

class Solution {
    public int ans = 0;
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        if(n<=0)
            return ans;
        initChess(chess,n);
        Nq(chess,0,n);
        return ans;
    }
    public void initChess(char[][] chess,int n){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                chess[i][j]='.';
    }
    public void Nq(char[][] chess,int row,int n){
        if(row==n){
            ans++;
            return;
        }
        for(int i=0;i<n;i++){
            if(check(chess,row,i,n)==false)
                continue;
            chess[row][i]='Q';
            Nq(chess,row+1,n);
            chess[row][i]='.';
        }
    }

    public boolean check(char[][] chess,int row,int column,int n){
        for(int i=0;i<n;i++){
            if(chess[row][i]=='Q'||chess[i][column]=='Q')
                return false;
        }
        int x=row,y=column;
        while(x>=0&&y>=0){
            if(chess[x][y]=='Q')
                return false;
            x--;
            y--;
        }
        x=row;
        y=column;
        while(x<n&&y<n){
            if(chess[x][y]=='Q')
                return false;
            x++;
            y++;
        }
        x=row;
        y=column;
        while(x<n&&y>=0){
            if(chess[x][y]=='Q')
                return false;
            x++;
            y--;
        }
        x=row;
        y=column;
        while(x>=0&&y<n){
            if(chess[x][y]=='Q')
                return false;
            x--;
            y++;
        }
        return true;
    }
}

一个很骚的题解
class Solution {
    final static int []SOLS=new int[]{1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200};
    public int totalNQueens(int n) {
        return   SOLS[n];
    }
}