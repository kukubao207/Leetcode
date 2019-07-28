package pdd20190728;

import java.util.Arrays;
import java.util.Scanner;

public class pdd4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] L = new int[n];
        int[] W = new int[n];
        for (int i = 0; i < n; i++)
            L[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            W[i] = sc.nextInt();
        Arrays.sort(W);

        int[] ret = new int[n];
        for (int i = 0; i < n; i++)
            ret[i] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (L[i] > L[j] && ret[j] + 1 > ret[i])
                    ret[i] = ret[j] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (ret[i] < ret[i - 1])
                swap(ret, i, i - 1);
        }
        System.out.println(ret[n - 1]);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
