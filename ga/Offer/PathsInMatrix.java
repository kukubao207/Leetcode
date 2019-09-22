package Offer;

/**矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathsInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[][] vis = new int[rows][cols];
        boolean res = false;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                res = res || dfs(matrix, rows, cols, str, i, j, 0, vis);
                if(res == true)
                    return true;
            }
        }
        return res;
    }
    public boolean dfs(char[] matrix, int rows, int cols, char[] str, int i, int j, int t, int[][] vis){
        if(t == str.length)
            return true;
        if(i >= rows || j >= cols || i < 0 || j < 0)
            return false;
        boolean res = false;
        if(vis[i][j] == 0 && matrix[i * cols + j] == str[t]){
            vis[i][j] = 1;
            res = res || dfs(matrix, rows, cols, str, i + 1, j, t + 1, vis);
            res = res || dfs(matrix, rows, cols, str, i - 1, j, t + 1, vis);
            res = res || dfs(matrix, rows, cols, str, i, j + 1, t + 1, vis);
            res = res || dfs(matrix, rows, cols, str, i, j - 1, t + 1, vis);
            if(!res)
                vis[i][j] = 0;
        }
        return res;
    }
}
