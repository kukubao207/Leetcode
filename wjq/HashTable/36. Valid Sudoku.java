36. Valid Sudoku
        Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        A partially filled sudoku which is valid.

        The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
        Example 1:

        Input:
        [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
        ]
        Output: true
        Example 2:

        Input:
        [
        ["8","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
        ]
        Output: false
        Explanation: Same as Example 1, except with the 5 in the top left corner being
        modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
        Note:

        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.
        The given board contain only digits 1-9 and the character '.'.
        The given board size is always 9x9.

题意
判断是不是一个合法的9*9数独（不一定可求解）
1.列中元素为1-9和.且不重复
2.行中元素为1-9和.且不重复
3.每9个小方块为1-9和.且不重复

我的思路
直接模拟，一次过，bug free~
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //检查每一行不重复
        for(int i=0;i<9;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                if(board[i][j]-'0'<0||board[i][j]-'0'>9)
                    return false;
                if(set.contains(board[i][j]-'0'))
                    return false;
                set.add(board[i][j]-'0');
            }
        }
        //检查每一列不重复
        for(int i=0;i<9;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][i]=='.')
                    continue;
                if(board[j][i]-'0'<0||board[j][i]-'0'>9)
                    return false;
                if(set.contains(board[j][i]-'0'))
                    return false;
                set.add(board[j][i]-'0');
            }
        }
        //检查每9个不重复
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(i%3==0&&j%3==0){
                    Set<Integer> set = new HashSet<>();
                    for(int m=i;m<i+3;m++)
                        for(int n=j;n<j+3;n++){
                            if(board[m][n]=='.')
                                continue;
                            if(board[m][n]-'0'<0||board[m][n]-'0'>9)
                                return false;
                            if(set.contains(board[m][n]-'0'))
                                return false;
                            set.add(board[m][n]-'0');
                        }
                }
            }
        }
        return true;
    }

}

别人的思路
明显要比我的好很多
别人用Set<String>来做是否重复的判断
public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}