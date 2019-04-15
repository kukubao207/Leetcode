package niuke;

import java.util.Scanner;

public class Dijkstra {
    private static int[][] G;
    private static int[] dist;
    private static int n;
    private static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        G = new int[n][n];
        dist = new int[n];
        start = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                G[i][j] = sc.nextInt();
        }
        dijkstra();
        printDist();
    }

    public static void dijkstra() {
        boolean solved[] = new boolean[n];

        //初始化dist数组
        for (int j = 0; j < n; j++)
            dist[j] = G[start][j];
        //到start的最短路径已找到
        solved[start] = true;
        for (int i = 0; i < n - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int v = 0;
            for (int j = 0; j < n; j++) {
                if (solved[j] == false && dist[j] != -1 && dist[j] < minDist) {
                    v = j;
                    minDist = dist[j];
                }
            }
            solved[v] = true;
            //更新dist数组
            for (int j = 0; j < n; j++) {
                if (solved[j] == false && G[v][j] != -1 && (dist[v] + G[v][j] < dist[j]||dist[j]==-1))
                    dist[j] = dist[v] + G[v][j];
            }
        }
    }

    public static void printDist() {
        int coutCount = 1;
        for (int i = 0; i < n; i++) {
            if (i == start)
                continue;
            if (coutCount == 1) {
                System.out.print(dist[i]);
                coutCount++;
            } else
                System.out.print("," + dist[i]);
        }
        System.out.println();
    }
}
