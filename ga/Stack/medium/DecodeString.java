package Stack.medium;

import java.util.Stack;

/**
 * 394.Given an encoded string, return its decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public static void main(String[] args){
        test();
    }
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) ==  ']'){
                String str = "";
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    String c = stack.pop();
                    str += c;
                }
                stack.pop();
                StringBuilder n = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    n.append(stack.pop());
                }
                int jj = Integer.parseInt(n.reverse().toString());
                String ss = "";
                for(int j = 0; j < jj; j++)
                    ss += str;
                stack.push(ss);
            }else
                stack.push(s.charAt(i) + "");
        }
        while(!stack.isEmpty())
            builder.append(stack.pop());
        return builder.reverse().toString();
    }

    public static void test(){
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        String s4 = "100[leetcode]";
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
        System.out.println(decodeString(s4));
    }
}
