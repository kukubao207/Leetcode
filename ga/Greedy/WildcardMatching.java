package Greedy;
//44. Wildcard Matching
//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
//
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//The matching should cover the entire input string (not partial).
//
//Note:
//
//s could be empty and contains only lowercase letters a-z.
//p could be empty and contains only lowercase letters a-z, and characters like ? or *.
//Example 1:
//
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
//Example 2:
//
//Input:
//s = "aa"
//p = "*"
//Output: true
//Explanation: '*' matches any sequence.
//Example 3:
//
//Input:
//s = "cb"
//p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
//Example 4:
//
//Input:
//s = "adceb"
//p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
//Example 5:
//
//Input:
//s = "acdcb"
//p = "a*c?b"
//Output: false
public class WildcardMatching {
    //1.动态规划
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];//dp[i][j]表示s1的前i个字符，和s2的前j个字符，能否匹配
        //初始化
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];//s2的第 j 个字符匹配空串||s2的第 j 个字符匹配s1的第 i 个字符
                }
            }
        }
        return dp[m][n];
    }
    //2.双指针
    public boolean isMatch1(String s, String p) {
        int  i = 0, j = 0, match = 0, tmpIndex = -1;
        //遍历整个字符串
        while (i < s.length()){
            // 一对一匹配，两指针同时后移。
            if (j < p.length()  && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))){
                i++;
                j++;
            }
            // 碰到 *，假设它匹配空串，并且用 startIdx 记录 * 的位置，记录当前字符串的位置，p 后移
            else if (j < p.length() && p.charAt(j) == '*'){
                tmpIndex = j;
                match = i;
                j++;
            }
            // 当前字符不匹配，并且也没有 *，回退
            // p 回到 * 的下一个位置
            // match 更新到下一个位置
            // s 回到更新后的 match
            // 这步代表用 * 匹配了一个字符
            else if (tmpIndex != -1){
                j = tmpIndex + 1;
                match++;
                i = match;
            }
            //字符不匹配，也没有 *，返回 false
            else return false;
        }
        while(j < p.length() && p.charAt(j) == '*')
            j++;
        return j == p.length();
    }
}
