package tx;

import java.util.Scanner;

public class tx4 {
    private static int pathCount = 0;
    private static boolean[][] vis;
    private static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        a = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = sc.nextInt();

        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();
        int W = sc.nextInt();

        vis = new boolean[M][N];

        dfs(X,Y,M,N,Z,W);
        System.out.println(pathCount);
    }

    public static void dfs(int i, int j, int M, int N, int Z, int W) {
        if (i == Z && j == W) {
            pathCount++;
            return;
        }
        vis[i][j] = true;
        //深搜下方节点
        if (isValid(i + 1, j, M, N) && vis[i + 1][j] == false && a[i + 1][j] > a[i][j])
            dfs(i + 1, j, M, N, Z, W);
        //深搜上方节点
        if (isValid(i - 1, j, M, N) && vis[i - 1][j] == false && a[i - 1][j] > a[i][j])
            dfs(i - 1, j, M, N, Z, W);
        //深搜左方节点
        if (isValid(i, j - 1, M, N) && vis[i][j - 1] == false && a[i][j - 1] > a[i][j])
            dfs(i, j - 1, M, N, Z, W);
        //深搜右方节点
        if (isValid(i, j + 1, M, N) && vis[i][j + 1] == false && a[i][j + 1] > a[i][j])
            dfs(i, j + 1, M, N, Z, W);
        vis[i][j]=false;
    }

    public static boolean isValid(int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N)
            return false;
        else
            return true;
    }
}
