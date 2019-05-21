package BackTracking;
//79. 单词搜索
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//示例:
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false.
public class WordSearch {
    public static void main(String args[]){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];//存放是否访问过
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean res = dfs(board, visited, word, 0, i, j);
                if(res)
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int[][] visited, String word, int index, int i, int j){
        if(index == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        if(visited[i][j] == 0 && board[i][j] == word.charAt(index)){
            visited[i][j] = 1;
            boolean res = dfs(board, visited, word, index + 1, i, j + 1)
                    || dfs(board, visited, word, index + 1, i + 1, j)
                    || dfs(board, visited, word, index + 1, i - 1, j)
                    ||dfs(board, visited, word, index + 1, i, j - 1);
            visited[i][j] = 0;
            return res;
        }
        return false;
    }
}
