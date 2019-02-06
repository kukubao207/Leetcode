37. Sudoku Solver

        Write a program to solve a Sudoku puzzle by filling the empty cells.

        A sudoku solution must satisfy all of the following rules:

        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
        Empty cells are indicated by the character '.'.


        ...and its solution numbers marked in red.

        Note:

        The given board contain only digits 1-9 and the character '.'.
        You may assume that the given Sudoku puzzle will have a single unique solution.
        The given board size is always 9x9.

题意
求解数独
思路
回溯法 O（9^m） m为.的数量

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.')
                    continue;
                for(int n=1;n<=9;n++){
                    char num = (char)(n+'0');
                    if(!isValid(i,j,num,board))
                        continue;
                    board[i][j]=num;
                    if(solve(board))
                        return true;
                    else
                        board[i][j]='.';
                }
                return false;
            }
        }
        return true;
    }
    public boolean isValid(int i,int j,char n,char[][] board){
        for(int k=0;k<9;k++){
            if(board[i][k]==n)
                return false;
            if(board[k][j]==n)
                return false;
            if(board[3*(i/3)+k/3][3*(j/3)+k%3]==n)
                return false;
        }
        return true;
    }

}