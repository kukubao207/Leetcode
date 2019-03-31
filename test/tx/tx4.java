package tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tx4 {
    private int[] found = new int[100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[6];
        for (int i = 0; i < 6; i++)
            a[i] = sc.nextInt();

        //边长为6的
        int ans = 0;
        while (a[5] > 0) {
            a[5]--;
            ans++;
        }

        //边长为5的
        while (a[4] > 0) {
            a[4]--;
            a[0] = Math.max(a[0] - 11, 0);
            ans++;
        }
        //边长为4的
        while (a[3] > 0) {
            a[3]--;
            //边长为2的超过5个，肯定先放边长为2的
            if (a[1] >= 5)
                a[1] = Math.max(a[1] - 5, 0);
                //边长为2的小于5个，放完边长2的肯定去放边长为1的
            else {
                a[0] = Math.max(a[0] - 4 * (5 - a[1]), 0);
                a[1] = 0;
            }
            ans++;
        }
        //边长为3的
        while (a[2] >= 4) {
            a[2] = Math.max(a[2] - 4, 0);
            ans++;
        }
        //边长为3的还有剩余
        if (a[2] > 0) {
            switch (a[2]) {
                case 1:
                    if (a[1] >= 5) {
                        a[1] = Math.max(a[1] - 5, 0);
                        a[0] = Math.max(a[0] - 7, 0);
                    } else {
                        a[0] = Math.max(a[0] - (7 + 4 * (5 - a[1])), 0);
                        a[1] = 0;
                    }
                    break;
                case 2:
                    if (a[1] >= 3) {
                        a[1] = Math.max(a[1] - 3, 0);
                        a[0] = Math.max(a[0] - 6, 0);
                    } else {
                        a[0] = Math.max(a[0] - 6 + 4 * (3 - a[1]), 0);
                        a[1] = 0;
                    }
                    break;
                case 3:
                    if (a[1] >= 1) {
                        a[1] = Math.max(a[1] - 1, 0);
                        a[0] = Math.max(a[0] - 5, 0);
                    } else {
                        a[0] = Math.max(a[0] - 9, 0);
                    }
                    break;
            }
            ans++;
        }
        while (a[1] >= 9) {
            a[1] = Math.max(a[1] - 9, 0);
            ans++;
        }
        if (a[1] > 0) {
            a[0] = Math.max(a[0] - 4 * (9 - a[1]), 0);
            a[1] = 0;
            ans++;
        }
        while (a[0] > 0) {
            a[0] = Math.max(a[0] - 36, 0);
            ans++;
        }
        System.out.println(ans);
    }
}
