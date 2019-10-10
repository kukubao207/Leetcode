242. Valid Anagram

        Given two strings s and t , write a function to determine if t is an anagram of s.

        Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true
        Example 2:

        Input: s = "rat", t = "car"
        Output: false
        Note:
        You may assume the string contains only lowercase alphabets.

        Follow up:
        What if the inputs contain unicode characters? How would you adapt your solution to such case?


相同字母异序词

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] count = new char[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        for (char c : t.toCharArray())
            count[c - 'a']--;
        for (int i = 0; i < 26; i++)
            if (count[i] != 0)
                return false;
        return true;
    }
}