5. Longest Palindromic Substring


Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"


我的思路
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        String res = "";
        int longest=0,m,n;
        int start=0,end=1;
        for(int i=0;i<s.length();i++){
            //奇数
            m=i;
            n=i;
            while(m>=0&&n<s.length()&&s.charAt(m)==s.charAt(n)){
                m--;
                n++;
            }
            if(n-m-1>longest){
                longest = n-m-1;
                start=m+1;
                end=n;
            }

            //偶数
            m=i;
            n=i+1;
            while(m>=0&&n<s.length()&&s.charAt(m)==s.charAt(n)){
                m--;
                n++;
            }
            if(n-m-1>longest){
                longest = n-m-1;
                start=m+1;
                end=n;
            }
        }
        return s.substring(start,end);
    }


}

动态规划思路
dp[i][j] =  s[i]==s[j]&&(j-i<3||dp[i+1][j-1])
代表 以i为起始下标，j为终止下标的子串是否为回文串。
如果s[i]==s[j]  我们需要知道  s[ i+1 ~ j-1 ]的子串是否为回文串
由于i+1要先比i算出来，所以第一层for循环从尾部开始
j-1要先比j算出来，所以第二层for循环从i开始开始，不可以从0开始，会导致数组越界。

j从i开始，数组不会越界，因为 当i=0，j=0时，j-i<3，不会去判断 dp[1][-1]是否为回文串


class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        int m=s.length();
        boolean[][] dp = new boolean[m][m];
        int max_len = 0;
        int start=0,end=0;
        for(int i=m-1;i>=0;i--){
            for(int j=i;j<m;j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1])){
                    dp[i][j]=true;
                }
                if(dp[i][j]){
                    if(max_len<j-i+1){
                        max_len=j-i+1;
                        start=i;
                        end=j+1;
                    }
                }
            }
        }
        return s.substring(start,end);
    }


}