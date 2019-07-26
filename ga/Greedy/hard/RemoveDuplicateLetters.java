package Greedy.hard;

import java.util.Stack;

//316. Remove Duplicate Letters
//Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
//
//Example 1:
//
//Input: "bcabc"
//Output: "abc"
//Example 2:
//
//Input: "cbacdcbc"
//Output: "acdb"
public class RemoveDuplicateLetters {
    //遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(stack.contains(c))
                continue;
            //public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
            while(!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            stack.push(c);
        }
        char chars[] = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }
}

//这个题是春招时候拼多多的第二个题。
// 删除字符串，
//    public String removeDuplicateLetters(String s) {
//        int[] cnt = new int[26];
//        for (int i = 0; i < s.length(); i++)
//            cnt[s.charAt(i) - 'a']++;
//        int pos = 0; // the position for the smallest s[i]
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) < s.charAt(pos))
//                pos = i;
//            if (--cnt[s.charAt(i) - 'a'] == 0)
//                break;
//        }
//        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
//    }
