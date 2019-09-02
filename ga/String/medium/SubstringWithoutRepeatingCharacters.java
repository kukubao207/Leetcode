package String.medium;

import java.util.HashSet;
import java.util.Set;

//3. Longest Substring Without Repeating Characters
//Given a string, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class SubstringWithoutRepeatingCharacters {
    public static void test(){
        String s = "dvdf";
        String s2 = " ";
        String s3 = "au";
        String s4 = "abcabcbb";
        String s5 = "pwwkew";
        System.out.print(lengthOfLongestSubstring(s));
        System.out.print(lengthOfLongestSubstring(s2));
        System.out.print(lengthOfLongestSubstring(s3));
        System.out.print(lengthOfLongestSubstring(s4));
        System.out.print(lengthOfLongestSubstring(s5));
    }
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            Set<Character> set = new HashSet<Character>();
            set.add(s.charAt(i));
            int max = 1;
            if(res == 0)
                res = 1;
            for(int j = i + 1; j < s.length(); j++){
                boolean bool = set.add(s.charAt(j));
                if(bool){
                    max++;
                    if(max > res)
                        res = max;
                }
                if(!bool)
                    break;
            }
        }
        return res;
    }
    public static void main(String args[]){
        test();
    }
}
