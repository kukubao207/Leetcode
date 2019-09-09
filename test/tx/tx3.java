package tx;

import java.util.*;

public class tx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (a[0][i] == 1)
                dp[0][i] = dp[0][i - 1] + 1;
            else
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            if (a[i][0] == 1)
                dp[i][0] = dp[i - 1][0] + 1;
            else
                dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        for (int i = 1; i < n - 1; i++) {

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println(dp[n - 1][n - 1]);
    }

}
