package Stack.easy;
//20. Valid Parentheses
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.
//
//Example 1:
//
//Input: "()"
//Output: true
//Example 2:
//
//Input: "()[]{}"
//Output: true
//Example 3:
//
//Input: "(]"
//Output: false
//Example 4:
//
//Input: "([)]"
//Output: false
//Example 5:
//
//Input: "{[]}"
//Output: true

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args){
        test();
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int size = s.length();
        while(i < size){
            if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    return false;
                char c = stack.pop();
                if(c != '(')
                    return false;
            }else if(s.charAt(i) == '}'){
                if(stack.isEmpty())
                    return false;
                char c = stack.pop();
                if(c != '{')
                    return false;
            }else if(s.charAt(i) == ']'){
                if(stack.isEmpty())
                    return false;
                char c = stack.pop();
                if(c != '[')
                    return false;
            }else{
                stack.push(s.charAt(i));
            }
            i++;
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void test(){
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = ")";
        String s7 = "(";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s7));
    }
}
