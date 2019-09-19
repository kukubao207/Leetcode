package tx;

import java.util.*;

public class tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int w[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            w[i] = sc.nextInt();
        int sum = 0;
        for (int weight : w) {
            sum += weight;
        }
        double p[] = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = w[i] / (double)sum;
        }
        int fromZeroRemain = lastRemain(n, m);
        double res = 0;
        for (int i = 0; i < n; i++) {
            int idx = (fromZeroRemain + i) % n;
//            System.out.println(i + "," + idx);
            if (a[idx] == 1)
                res += p[i];
        }
        System.out.println(String.format("%.5f", res));
    }

    public static int lastRemain(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }
}
