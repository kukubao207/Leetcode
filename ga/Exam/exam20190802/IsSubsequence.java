package Exam.exam20190802;
//392. Is Subsequence
//Given a string s and a string t, check if s is subsequence of t.
//
//You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
//
//Example 1:
//s = "abc", t = "ahbgdc"
//
//Return true.
//
//Example 2:
//s = "axc", t = "ahbgdc"
//
//Return false.
//
//Follow up:
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
//
//Credits:
//Special thanks to @pbrother for adding this problem and creating all test cases.
public class IsSubsequence {
    //1.动态规划
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];//boolean默认false
        for(int i = 0; i <= n; i++)
            dp[0][i] = true;
        //dp[i][0]默认为false
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1))//比较的时候注意index从0开始
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    //2.贪心思路:找到最近的匹配位置,然后从这个位置后面继续找下一个.
    public boolean isSubsequence1(String s, String t) {
        int index = -1;
        for(char c: s.toCharArray()){
            index = t.indexOf(c, index + 1);//返回此字符串中第一次出现指定字符的索引，从指定的索引开始搜索（包含fromIndex）。没有找到则返回-1。
            if(index == -1)
                return false;
        }
        return true;
    }
}
