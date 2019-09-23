package Exam.microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by myh on 2019/9/23.
 */
public class exam2 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int D = 10;
        int k = 1;
        System.out.print(GetMinDays(D, k));
    }

    //dp[i]定义为将i为目标的最少天数
    public static int GetMinDays(int D, int k){
        int[] primes = getPrimeNum(k);
        int[] dp = new int[D + 1];
        Arrays.fill(dp, -1);
        for(int i = 0; i < k; i++){
            dp[primes[i]] = 1;
        }

        for(int i = 2; i <= D; i++){
            if(dp[i] == 1)
                continue;
            else{
                int index = GetClosestMaxNum(i, primes, k);
                for(int j = index; j >= 0; j--){
                    if(dp[i - primes[j]] == -1)
                        continue;
                    else{
                        dp[i] = dp[i - primes[j]] + 1;
                        break;
                    }
                }
            }
        }
        return dp[D];
    }

    public static int GetClosestMaxNum(int i, int[] primes, int k){
        for(int j = k - 1; j >= 0; j--)
            if(primes[j] <= i)
                return j;
        return -1;
    }

    public static int[] getPrimeNum(int k) {
        int count = 0;
        boolean[] isNotPrime = new boolean[105000];
        int[] res = new int[k];
        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int n = i + i; n < isNotPrime.length; n += i) {
                    isNotPrime[n] = true;
                }
                res[count++] = i;
            }
            if (count == k)
                return res;
        }
        return null;
    }
}
