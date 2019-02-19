91. Decode Ways

        A message containing letters from A-Z is being encoded to numbers using the following mapping:

        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
        Given a non-empty string containing only digits, determine the total number of ways to decode it.

        Example 1:

        Input: "12"
        Output: 2
        Explanation: It could be decoded as "AB" (1 2) or "L" (12).
        Example 2:

        Input: "226"
        Output: 3
        Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

解题思路

这道题要想到DP就好做了
从字符串尾部开始遍历，
计算dp[i]时，
        考虑：
        如果第i个字符为0，那么 dp[i]应当就为0
        第i个字符合法，那么 add  dp[i+1]
        第i和i+1个字符结合合法，那么 add dp[i+2]


index  0 1 2 3
string 2 2 6
dp     3 2 1 1

index  0 1 2 3 4 5
string 1 0 2 2 6
dp     3 0 3 2 1 1

index  0 1 2 3 4 5 6
string 3 6 2 8 4 1
dp     1 1 1 1 1 1 1

index  0 1 2 3 4 5
string 1 2 1 2 6
dp     8 5 3 2 1 1

class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        dp[s.length()]=1;
        if(s.charAt(s.length()-1)!='0')
            dp[s.length()-1]=1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='0')
                continue;
            else{
                if(Integer.parseInt(s.substring(i,i+2))<=26){
                    dp[i]=dp[i+1]+dp[i+2];
                }else
                    dp[i]=dp[i+1];
            }
        }
        return dp[0];
    }

}



