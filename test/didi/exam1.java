package didi;

import java.util.Scanner;

public class exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int res = 0;
        for (int step = 1; (n / step >= 3); step++) {
            int k = -1;
            if (n % step == 0)
                k = n / step;
            if (k == -1)
                continue;
            int temp = solveMax(a, step);
            res = Math.max(res, temp);
        }
        System.out.println(res);
    }
    public static int solveMax(int a[], int step) {
        boolean [] vis = new boolean[a.length];
        for (int i = 0; i < vis.length; i++)
            vis[i] = false;
        int start = 0;
        int maxAns = Integer.MIN_VALUE;
        while (start < a.length && vis[start] == false) {
            int temp = start;
            int sum = 0;
            do{
                sum += a[temp];
                vis[temp] = true;
                temp = (temp + step) % a.length;
            }while (temp != start);
            maxAns = Math.max(maxAns, sum);
            start++;
        }
        return maxAns;
    }

}
