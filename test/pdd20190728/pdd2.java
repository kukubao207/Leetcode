package pdd20190728;

import java.util.Scanner;

public class pdd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aa = sc.nextLine();
        String[] a = aa.split(" ");
        judge(a, a.length, 0);
        if (ok)
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }

    public static boolean ok = false;

    public static void judge(String[] a, int n, int m) {
        if (n == m) {
            if (a[n-1].charAt(a[n-1].length()-1) == a[0].charAt(0))
                ok = true;
            return;
        }
        for (int i = m; i < n; i++) {
            if (m > 0 && a[m - 1].charAt(a[m - 1].length() - 1) == a[i].charAt(0)) {
                swap(a, m, i);
                judge(a, n, m + 1);
                swap(a, m, i);
            } else if (m == 0) {
                swap(a, m, i);
                judge(a, n, m + 1);
                swap(a, m, i);
            }
        }
    }

    public static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
