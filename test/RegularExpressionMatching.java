public class RegularExpressionMatching {
    public static void main(String[] args) {
        String a = "a";
        String b = ".*";
        boolean res = match(a.toCharArray(), b.toCharArray());
    }

    public static boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < pattern.length + 1; i++) {
            if (pattern[i - 1] == '*' && i >= 2)
                dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i < str.length + 1; i++) {
            for (int j = 1; j < pattern.length + 1; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    if (str[i - 1] == pattern[j - 2] || pattern[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[str.length][pattern.length];
    }

}
