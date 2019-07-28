package pdd20190728;

import java.util.Arrays;
import java.util.Scanner;

public class pdd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String[] aa = a.split(" ");
        String[] bb = b.split(" ");
        int[] aaa = new int[aa.length];
        int[] bbb = new int[bb.length];
        int l = -1, r = -1, ll = -1, rr = -1;
        for (int i = 0; i < aaa.length; i++) {
            aaa[i] = Integer.parseInt(aa[i]);
            bbb[i] = Integer.parseInt(bb[i]);
        }
        for (int i = 1; i < aaa.length; i++) {
            if (aaa[i] <= aaa[i - 1]) {
                l = i - 1;
                r = i;
                if (i - 2 >= 0) {
                    ll = i - 2;
                }
                if (i + 1 < aaa.length) {
                    rr = i + 1;
                }
                break;
            }
        }
        Arrays.sort(bbb);
        // 要么替换r这个数
        boolean find = false;
        for (int i = bbb.length - 1; i >= 0; i--) {
            if (l != -1 && rr != -1) {
                if (bbb[i] < aaa[rr] && bbb[i] > aaa[l]) {
                    aaa[r] = bbb[i];
                    find = true;
                    break;
                }
            } else if (l == -1 && rr != -1) {
                if (bbb[i] < aaa[rr]) {
                    aaa[r] = bbb[i];
                    find = true;
                    break;
                }

            } else if (l != -1 && rr == -1) {
                if (bbb[i] > aaa[l]) {
                    aaa[r] = bbb[i];
                    find = true;
                    break;
                }
            } else {
                continue;
            }
        }
        if (find) {
            for (int i = 0; i < aaa.length; i++)
                System.out.print(aaa[i] + " ");
            return;
        }
        // 要么替换l这个数
        for (int i = bbb.length - 1; i >= 0; i--) {
            if (ll != -1 && r != -1) {
                if (bbb[i] < aaa[r] && bbb[i] > aaa[ll]) {
                    aaa[l] = bbb[i];
                    find = true;
                    break;
                }
            } else if (ll == -1 && r != -1) {
                if (bbb[i] < aaa[r]) {
                    aaa[l] = bbb[i];
                    find = true;
                    break;
                }
            } else if (ll != -1 && r == -1) {
                if (bbb[i] > aaa[ll]) {
                    aaa[l] = bbb[i];
                    find = true;
                    break;
                }
            }
        }
        if (find) {
            for (int i = 0; i < aaa.length; i++)
                System.out.print(aaa[i] + " ");
        } else {
            System.out.println("NO");
        }

    }
}
//1 3 7 4 10
//2 1 5 8 9

//1 3 4 7 1
//2 1 5 8 9