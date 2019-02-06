public class BackTrackingSolveSudoku {
    public static void main(String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        solve(board);
    }
    public static boolean solve(char[][] board){
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
    public static boolean isValid(int i,int j,char n,char[][] board){
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
