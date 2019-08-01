package DP.hard;

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