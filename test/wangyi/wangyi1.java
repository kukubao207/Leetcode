package wangyi;

import java.util.Scanner;

public class wangyi1 {
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
    }
}
//1 3 7 4 10
//2 1 5 8 9

//1 3 4 7 1
//2 1 5 8 9