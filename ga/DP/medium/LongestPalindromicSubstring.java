package DP.medium;

/**
 * 5.给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        int n = s.length();
        int max = 0;
        String res = "";
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = n - 1; j >= 0; j--){
                if(chars[i] == chars[j] && (j > i - 2 || dp[i - 1][j + 1] == 1)){
                    dp[i][j] = 1;
                    if((i - j + 1) > max){
                        max = i - j + 1;
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }
    //判断回文串的动态规划
    //dp[i][j] 表示 S[i] 至 S[j] 所表示的子串是否是回文子串，是则为 1，不是则为 0
    // 若 S[i] == S[j]，那么只要 S[i+1] 至 S[j-1] 是回文子串，S[i] 至 S[j] 就是回文子串；如果S[i+1] 至 S[j-1] 不是回文子串，则 S[i] 至 S[j] 也不是回文子串。
    //若 S[i] != S[j]，那么 S[i] 至 S[j] 一定不是回文子串。
//    public boolean isHuiWen(char[] chars, int i , int j){
//        if(i >= j)
//            return true;
//        if(chars[i] == chars[j])
//            return isHuiWen(chars, i + 1, j - 1);
//        else
//            return false;
//    }


}
