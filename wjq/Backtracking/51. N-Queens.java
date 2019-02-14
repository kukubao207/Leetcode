51. N-Queens
        The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

        Given an integer n, return all distinct solutions to the n-queens puzzle.

        Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

        Example:

        Input: 4
        Output: [
        [".Q..",  // Solution 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // Solution 2
        "Q...",
        "...Q",
        ".Q.."]
        ]
        Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


我的思路
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        if(n<=0)
            return res;
        initChess(chess,n);
        Nq(res,chess,0,n);
        return res;
    }
    public void initChess(char[][] chess,int n){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                chess[i][j]='.';
    }
    public void Nq(List<List<String>> res,char[][] chess,int row,int n){
        if(row==n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(String.valueOf(chess[i]));
            }
            res.add(temp);
            return;
        }
        for(int i=0;i<n;i++){
            if(check(chess,row,i,n)==false)
                continue;
            chess[row][i]='Q';
            Nq(res,chess,row+1,n);
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