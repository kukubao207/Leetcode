package tx;

import java.util.*;

public class tx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            int num[] = new int[k];
            for (int j = 0; j < k; j++)
                num[j] = sc.nextInt();
            Arrays.sort(num);
            divide(num);
        }
    }

    static void divide(int num[]) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        boolean f[][] = new boolean[num.length + 1][sum / 2 + 1];
        for (int i = 0; i < num.length; i++)
            for (int j = 0; j < sum / 2 + 1; j++)
                f[i][j] = false;

        f[0][0] = true;
        for (int k = 0; k < num.length; k++) {
            for (int i = Math.min(k , num.length / 2); i >= 1; i--) {
                for (int j = 0; j <= sum / 2; j++) {
                    if (j >= num[k] && f[i - 1][j - num[k]])
                        f[i][j] = true;
                }
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (f[num.length / 2][i]) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = sum - i;
                Arrays.sort(res);
                System.out.println(res[0] + " " + res[1]);
                break;
            }
        }
    }
}