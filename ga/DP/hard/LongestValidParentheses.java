package DP.hard;
//32. 最长有效括号
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//        示例 1:
//
//        输入: "(()"
//        输出: 2
//        解释: 最长有效括号子串为 "()"
//        示例 2:
//
//        输入: ")()())"
//        输出: 4
//        解释: 最长有效括号子串为 "()()"
public class LongestValidParentheses {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int res = 0;
        if(s == null || s.length() == 0)
            return res;
        int[] dp = new int[s.length()];//dp[i]表示以i为结尾的有效括号的最大长度（必须包含i处字符）

        for(int i = 1; i < s.length(); i++) {
            int n = i - 1 - dp[i - 1];
            if (n >= 0 && s.charAt(i) == ')' && s.charAt(n) == '('){
                if(n - 1 >= 0)
                    dp[i] = dp[i - 1] + dp[n - 1] + 2;
                else
                    dp[i] = dp[i - 1] + 2;

            }
            else
                dp[i] = 0;
            if(dp[i] > res)
                res = dp[i];

        }
        return res;
    }
}
