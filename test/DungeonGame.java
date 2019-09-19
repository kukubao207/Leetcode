public class DungeonGame {
    public static void main(String[] args) {
        int[][] d = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(d));
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        if (m == 0 || n == 0)
            return 0;
        int dp[][][] = new int[m][n][2];
        dp[0][0][0] = dungeon[0][0];
        dp[0][0][1] = -1 * dungeon[0][0] + 1;
        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i - 1][0] + dungeon[0][i];
            dp[0][i][1] = Math.max(dp[0][i - 1][1], -1 * dp[0][i][0] + 1);
        }
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + dungeon[i][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], -1 * dp[i][0][0] + 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                int left = Math.max(dp[i - 1][j][1], -1 * (dp[i - 1][j][0] + dungeon[i][j]) + 1);
                int top = Math.max(dp[i][j - 1][1], -1 * (dp[i][j - 1][0] + dungeon[i][j]) + 1);
                if (left < top) {
                    dp[i][j][0] = dp[i - 1][j][0] + dungeon[i][j];
                    dp[i][j][1] = left;
                } else {
                    dp[i][j][0] = dp[i][j - 1][0] + dungeon[i][j];
                    dp[i][j][1] = top;
                }
            }
        }
        return dp[m - 1][n - 1][1];
    }
}
