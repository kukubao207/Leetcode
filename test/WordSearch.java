public class WordSearch {
    public static void main(String[] args){
        char[][] board={{'a'}};
        String word="ab";
        Solution.exist(board,word);
    }
    public static class Solution {
        public static boolean exist(char[][] board, String word) {
            if(word.equals(""))
                return true;
            if(board.length==0||board[0].length==0)
                return false;

            boolean[][] vis = new boolean[board.length][board[0].length];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(word.charAt(0)==board[i][j]){
                        if(dfs(board,i,j,word,0,vis))
                            return true;
                    }
                }
            }
            return false;
        }
        public static boolean dfs(char[][] board,int i,int j,String word,int cur,boolean[][] vis){
            if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]||cur>=word.length()||word.charAt(cur)!=board[i][j])
                return false;
            if(cur==word.length()-1)
                return true;
            vis[i][j]=true;
            boolean res=dfs(board,i-1,j,word,cur+1,vis)||dfs(board,i,j-1,word,cur+1,vis)||dfs(board,i+1,j,word,cur+1,vis)||dfs(board,i,j+1,word,cur+1,vis);
            vis[i][j]=false;
            return res;
        }
    }
}
