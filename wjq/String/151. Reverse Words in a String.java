151. Reverse Words in a String

        Given an input string, reverse the string word by word.

        Example:

        Input: "the sky is blue",
        Output: "blue is sky the".
        Note:

        A word is defined as a sequence of non-space characters.
        Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
        You need to reduce multiple spaces between two words to a single space in the reversed string.
        Follow up: For C programmers, try to solve it in-place in O(1) space.

题意
将一个字符串的每个单词逆序输出

思路
从头到尾遍历字符串
用两个指针来记录每次遍历到的单词的起始下标

public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        int i=s.length()-1;
        while(i>=0){
            while(i>=0&&s.charAt(i)==' '){
                i--;
            }
            int j=i;
            while(j>=0&&s.charAt(j)!=' '){
                j--;
            }
            if(i<0)  //因为这个条件没有WA了一次，对于" 1"这个测试用例输出了 "1 "，说明我没有考虑前导空格的情况
                break;
            if(sb.length()==0){
                sb.append(s.substring(j+1,i+1));
            }else{
                sb.append(" ").append(s.substring(j+1,i+1));
            }
            i=j;
        }
        return sb.toString();
    }
}