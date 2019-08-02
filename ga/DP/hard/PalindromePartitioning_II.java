package DP.hard;
//132. Palindrome Partitioning II
//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//Example:
//
//Input: "aab"
//Output: 1
//Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
public class PalindromePartitioning_II {
    //“回文串”是一个正读和反读都一样的字符串
    //判断回文串的动态规划
    //dp[i][j] 表示 S[i] 至 S[j] 所表示的子串是否是回文子串，是则为 1，不是则为 0
    // 若 S[i] == S[j]，那么只要 S[i+1] 至 S[j-1] 是回文子串，S[i] 至 S[j] 就是回文子串；如果S[i+1] 至 S[j-1] 不是回文子串，则 S[i] 至 S[j] 也不是回文子串。
    //若 S[i] != S[j]，那么 S[i] 至 S[j] 一定不是回文子串。


    //1.f[i]表示前 i 个字符组成的子串，最少需要几次分割，才能变成都是回文串
    //对于所有的 j < i， 如果s[j, i]是回文串, 且 f[j] + 1 < f[i] 则 f[i] = f[j] + 1
    public int minCut(String s) {
        if(s == null || s.equals("") || s.length() == 0 || s.length() == 1)
            return 0;
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = -1;
        for(int i = 1; i <= n; i++){
            f[i] = i - 1;//初始化
            for(int j = 0; j < i; j++){
                if(isHuiWen(s, j, i - 1)){
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        return f[n];
    }
    public boolean isHuiWen(String str, int start, int end){
        int i = start; int j = end;
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
               return false;
            i++;
            j--;
        }
        return true;
    }

    //2.一次遍历
    //dp[i]:s[0:i]最少需要cut的次数
    public int minCut1(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < len; i++) {
            search(s, dp, i, i);
            search(s, dp, i, i + 1);
        }
        return dp[len - 1];
    }
    //遍历一遍给的串 以遍历点为中心找最大的回文串 更新dp
    //回文串有两种方式left为中心的奇数型 以left，left+1为中心的偶数型
    private void search(String s, int[] dp, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(left == 0)
                dp[right] = 0;
            else
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            left--;
            right++;
        }
    }
}
