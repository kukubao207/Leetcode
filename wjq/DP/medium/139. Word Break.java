139. Word Break

        Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note:

        The same word in the dictionary may be reused multiple times in the segmentation.
        You may assume the dictionary does not contain duplicate words.
        Example 1:

        Input: s = "leetcode", wordDict = ["leet", "code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".
        Example 2:

        Input: s = "applepenapple", wordDict = ["apple", "pen"]
        Output: true
        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        Note that you are allowed to reuse a dictionary word.
        Example 3:

        Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        Output: false

我的思路
dfs,暴力搜索 超时
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        return dfs(s,0,wordDict);
    }
    public boolean dfs(String str,int start,List<String> wordDict){
        if(start==str.length()){
            return true;
        }
        for(int i=start;i<str.length();i++){
            if(!wordDict.contains(str.substring(start,i+1)))
                continue;
            if(dfs(str,i+1,wordDict))
                return true;
        }
        return false;
    }
}

开始思考dp解法

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i<s.length();i++){
            if(wordDict.contains(s.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            for(int j=0;j<i;j++){
                if(dp[j]==true&&wordDict.contains(s.substring(j+1,i+1))){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()-1];
    }

}

//   l e e t c o d e
//   0 0 0 1 0 0 0 1

// a p p l e p e n a p p l e
// 0 0 0 0 1 0 0 1 0 0 0 0 1
// c a t s a n d o g
// 0 0 1 1 0 0 1 0 0
