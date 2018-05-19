130. Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

我的思路
做两次DFS,第一次把外面一圈的DFS掉,第二次把里面一圈的DFS掉.

class Solution {
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0)
            return;
        boolean[][] vis=new boolean[board.length][board[0].length];
        
        //先把外面一圈dfs掉
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||j==0||i==board.length-1||j==board[0].length-1){
                    if(vis[i][j]==false&&board[i][j]=='O')
                        dfs1(i,j,board,vis);
                }
            }
        }
        //再对里面一圈dfs
        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(vis[i][j]==false&&board[i][j]=='O')
                    dfs2(i,j,board,vis);
            }
        }
    }
    int dir[][]= {{1,0},{0,1},{0,-1},{-1,0}};
    void dfs1(int i,int j,char[][] board,boolean[][] vis){
        if(i<0||j<0||i>=board.length||j>=board[0].length||vis[i][j]==true||board[i][j]=='X')
            return;
        vis[i][j]=true;
        for(int k=0;k<4;k++){
            dfs1(i+dir[k][0],j+dir[k][1],board,vis);
        }
    }
    void dfs2(int i,int j,char[][] board,boolean[][] vis){
        if(i<0||j<0||i>=board.length||j>=board[0].length||vis[i][j]==true||board[i][j]=='X')
            return;
        vis[i][j]=true;
        board[i][j]='X';
        for(int k=0;k<4;k++){
            dfs2(i+dir[k][0],j+dir[k][1],board,vis);
        }
    }
}