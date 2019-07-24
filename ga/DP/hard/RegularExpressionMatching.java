package DP.hard;

//     10.Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).
//
//        Note:
//
//        s could be empty and contains only lowercase letters a-z.
//        p could be empty and contains only lowercase letters a-z, and characters like . or *.
//        Example 1:
//
//        Input:
//        s = "aa"
//        p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".
//        Example 2:
//
//        Input:
//        s = "aa"
//        p = "a*"
//        Output: true
//        Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//        Example 3:
//
//        Input:
//        s = "ab"
//        p = ".*"
//        Output: true
//        Explanation: ".*" means "zero or more (*) of any character (.)".
//        Example 4:
//
//        Input:
//        s = "aab"
//        p = "c*a*b"
//        Output: true
//        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
//        Example 5:
//
//        Input:
//        s = "mississippi"
//        p = "mis*is*p*."
//        Output: false
public class RegularExpressionMatching {
    //与44题类似
    //1.动态规划
    //动态规划算法则是自底向上的
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];//dp[i][j]表示s1的前i个字符，和s2的前j个字符，能否匹配
        dp[0][0] = true;
        //初始化//dp[i][0]肯定都为false不需要初始化
        for(int i = 1; i <= n; i++){
            if(i >= 2)
                dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                if(p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }
    //2.回溯（递归）
    //递归方式是自顶向下的
    public boolean isMatch1(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*'){//有*只会出现在第二个位置
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));//*匹配0||*匹配前一个字母
        }else{
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

}
