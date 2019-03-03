10. Regular Expression Matching

        Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
        The matching should cover the entire input string (not partial).

        Note:

        s could be empty and contains only lowercase letters a-z.
        p could be empty and contains only lowercase letters a-z, and characters like . or *.
        Example 1:

        Input:
        s = "aa"
        p = "a"
        Output: false
        Explanation: "a" does not match the entire string "aa".
        Example 2:

        Input:
        s = "aa"
        p = "a*"
        Output: true
        Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
        Example 3:

        Input:
        s = "ab"
        p = ".*"
        Output: true
        Explanation: ".*" means "zero or more (*) of any character (.)".
        Example 4:

        Input:
        s = "aab"
        p = "c*a*b"
        Output: true
        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
        Example 5:

        Input:
        s = "mississippi"
        p = "mis*is*p*."
        Output: false



// the induction rule is very similar to edit distance, where we also consider from the end.
// induction rule:
// 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
//    ######a(i)
//    ####a(j)
// 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
// 	  #######a(i)
//    ####.(j)
// 3. if p.charAt(j) == '*':
//    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
//       #####a(i)
//       ####b*(j)
//    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
//       ######a(i)
//       ####.*(j)
//
// 	  	 #####a(i)
//    	 ###a*(j)
//      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
//      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2]
//      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                char s_ch = s.charAt(i-1);
                char p_ch = p.charAt(j-1);
                if(p_ch=='.'||s_ch==p_ch){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p_ch=='*'){
                    //往前看一个字符
                    char p_ch_before = p.charAt(j-2);
                    if(s_ch!=p_ch_before&&p_ch_before!='.')
                        dp[i][j]=dp[i][j-2];
                    else
                        dp[i][j]= (dp[i][j-2]||dp[i-1][j]||dp[i-1][j-2]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}