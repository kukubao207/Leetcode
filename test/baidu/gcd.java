package baidu;

import java.math.BigInteger;
import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        System.out.println((n.multiply(n.subtract(BigInteger.valueOf(1))).subtract(BigInteger.valueOf(1))));
    }
    public static void maxLcmMinusGcd(int n) {
        long res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long curGcd = gcd(i, j);
                long curLcm = i / curGcd * j;
                res = Math.max(curLcm - curGcd, res);
//                System.out.println("i= " + i + ", j=" + j + " ||| " + curLcm + " , " + curGcd + ", res =" + (curLcm - curGcd));
            }
        }
        System.out.println("i=" + n + " res=" +res);
    }
    public static long gcd(long a, long b){
        long t = 0;
        while(b != 0){
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
