package String.easy;
//14. Longest Common Prefix
//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//Example 1:
//
//Input: ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//Note:
//
//All given inputs are in lowercase letters a-z.
//
//Accepted
//529,494
//Submissions
//1,554,893
public class LongestCommonPrefix {
    public static void test(){
        String[] strs = new String[]{"abab","aba",""};
        System.out.print(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0)
            return "";
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            String str = strs[i];
            if(str.equals(""))
                return "";
            for(int j = 0; j < str.length(); j++){
                if(j < res.length() && str.charAt(j) != res.charAt(j)){
                    res = res.substring(0, j);
                    break;
                }else if(j < res.length() && j == str.length() - 1){
                    res = str;
                    break;
                }
                else if(j >= res.length()){
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        test();
    }
}
