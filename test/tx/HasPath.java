package tx;

import java.util.Arrays;

public class HasPath {
    boolean find = false;

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'s', 'e', 'e'};
        new HasPath().hasPath(matrix, 3, 4, str);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //1. change matrix to 2d matrix
        char[][] mat = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            int row = i / cols;
            int column = i % cols;
            mat[row][column] = matrix[i];
        }
        boolean[][] vis = new boolean[rows][cols];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                init(vis);
                find = false;
                dfs(mat, i, j, str, 0, vis);
                if (find)
                    return true;
            }
        }
        return false;
    }

    public void init(boolean[][] vis) {
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++)
                vis[i][j] = false;
        }
    }

    public void dfs(char[][] mat, int i, int j, char[] str, int pos, boolean[][] vis) {
        if (pos == str.length) {
            find = true;
            return;
        }
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return;
        if (vis[i][j] == true)
            return;
        if (mat[i][j] != str[pos])
            return;
        vis[i][j] = true;
        dfs(mat, i + 1, j, str, pos + 1, vis);
        dfs(mat, i, j + 1, str, pos + 1, vis);
        dfs(mat, i - 1, j, str, pos + 1, vis);
        dfs(mat, i, j - 1, str, pos + 1, vis);
        vis[i][j] = false;
    }
}
