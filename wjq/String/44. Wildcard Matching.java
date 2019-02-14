44. Wildcard Matching
        Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

        '?' Matches any single character.
        '*' Matches any sequence of characters (including the empty sequence).
        The matching should cover the entire input string (not partial).

        Note:

        s could be empty and contains only lowercase letters a-z.
        p could be empty and contains only lowercase letters a-z, and characters like ? or *.
        Example 1:

        Input:
        s = "aa"
        p = "a"
        Output: false
        Explanation: "a" does not match the entire string "aa".
        Example 2:

        Input:
        s = "aa"
        p = "*"
        Output: true
        Explanation: '*' matches any sequence.
        Example 3:

        Input:
        s = "cb"
        p = "?a"
        Output: false
        Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
        Example 4:

        Input:
        s = "adceb"
        p = "*a*b"
        Output: true
        Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
        Example 5:

        Input:
        s = "acdcb"
        p = "a*c?b"
        Output: false

贪心解
class Solution {
    public boolean isMatch(String s, String p) {
        int s_idx=0,p_idx=0,idx=-1,match=0;
        while(s_idx<s.length()){
            if(p_idx<p.length()&&(p.charAt(p_idx)=='?'||s.charAt(s_idx)==p.charAt(p_idx))){
                s_idx++;
                p_idx++;
            }
            else if(p_idx<p.length()&&p.charAt(p_idx)=='*'){
                match=s_idx;
                idx=p_idx;
                p_idx++;
            }
            else if(idx!=-1){
                p_idx=idx+1;
                match++;
                s_idx=match;
            }
            else
                return false;
        }
        while(p_idx<p.length()&&p.charAt(p_idx)=='*')
            p_idx++;
        return p_idx==p.length();
    }
}

DP解
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j)){
                    match[i][j]=match[i+1][j+1];
                }else if(p.charAt(j)=='*'){
                    //match[i+1][j]表示*匹配掉i位这个字符，match[i][j+1]表示*匹配空字符
                    match[i][j]=match[i+1][j]||match[i][j+1];
                }else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }
}