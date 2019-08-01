package DP.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//115. Distinct Subsequences
//Given a string S and a string T, count the number of distinct subsequences of S which equals T.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Example 1:
//
//Input: S = "rabbbit", T = "rabbit"
//Output: 3
//Explanation:
//
//As shown below, there are 3 ways you can generate "rabbit" from S.
//(The caret symbol ^ means the chosen letters)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
//Example 2:
//
//Input: S = "babgbag", T = "bag"
//Output: 5
//Explanation:
//
//As shown below, there are 5 ways you can generate "bag" from S.
//(The caret symbol ^ means the chosen letters)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
public class DistinctSubsequences {
    public static void main(String[] args) {
        test();
    }
    //1.回溯会超时
    static int times = 0;
    public static int numDistinct1(String s, String t) {
        times = 0;
        if(s == null || t == null || s.equals("") || t.equals("") || s.length() < t.length())
            return 0;
        List<Character> tmp = new ArrayList<>();
        dfs(tmp, s, t, 0, 0);
        return times;
    }
    public static void dfs(List<Character> tmp, String s, String t, int s_start, int t_start){
        if(tmp.size() == t.length()){
            times++;
        }
        else{
            for(int i = s_start; i < s.length(); i++){
                if(s.charAt(i) == t.charAt(t_start)){
                    tmp.add(s.charAt(i));
                    dfs(tmp, s, t, i + 1, t_start + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    //2.动态规划
    //dp[i][j]为t前j个字符t[0..j-1]在s前i个字符s[0..i-1]中出现的次数
    //设dp[i][j]表示s[0:i-1]的子序列中t[0:j-1]出现的次数，则
        //1.若s[i-1] == t[j-1] => dp[i][j] = dp[i-1][j-1] (用s[i-1]与t[j-1]配对) + dp[i-1][j](抛弃s[i-1],不用s[i-1]与t[j-1]配对)
        //2.若s[i-1] != t[j-1] => dp[i-1][j] (直接抛弃s[i-1],不用s[i-1]与t[j-1]配对)
    public static int numDistinct(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化dp[i][0] = 1
        for (int i = 0; i <= m; i++) {//空字符串就是把所有的原字符串删掉
            dp[i][0] = 1;
        }
        //dp[0][i] = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = j; i <= m; i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
    public static void test(){
        String s1 = "rabbbit";
        String t1 = "rabbit";
        String s2 = "";
        String t2 = "rabbit";
        String s3 = "babgbag";
        String t3 = "bag";
        System.out.println(numDistinct(s1, t1));
        System.out.println(numDistinct(s2, t2));
        System.out.println(numDistinct(s3, t3));
    }

    // 我的思路
    // dp做多了发现，大概都是用一个dp二维数组，然后自己先把正确答案填到设计的表格里，再去找规律。
    // 我这种解题方式是"猜"，也可以是说找规律，没有什么思维难度，主要就是找规律。
    class Solution {
        public int numDistinct(String s, String t) {
            if (s == null || t == null || s.equals("") || t.equals(""))
                return 0;
            int[][] dp = new int[t.length()][s.length()];
            if (s.charAt(0) == t.charAt(0))
                dp[0][0] = 1;
            for (int i = 1; i < t.length(); i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(0))
                    dp[0][i] = dp[0][i - 1] + 1;
                else
                    dp[0][i] = dp[0][i - 1];
            }
            for (int i = 1; i < t.length(); i++) {
                for (int j = 1; j < s.length(); j++) {
                    if (s.charAt(j) == t.charAt(i)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[t.length() - 1][s.length() - 1];
        }
    }
}


