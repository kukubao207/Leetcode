14. Longest Common Prefix
        Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".

        Example 1:

        Input: ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String cmp = strs[0],res="";
        for(int i=0;i<cmp.length();i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()==i||strs[j].charAt(i)!=cmp.charAt(i)){
                    return res;
                }
            }
            res+=cmp.charAt(i);
        }
        return res;
    }
}