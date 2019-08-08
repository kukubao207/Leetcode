package String.medium;

import java.util.Stack;

//227. Basic Calculator II
//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
//
//Example 1:
//
//Input: "3+2*2"
//Output: 7
//Example 2:
//
//Input: " 3/2 "
//Output: 1
//Example 3:
//
//Input: " 3+5 / 2 "
//Output: 5
//Note:
//
//You may assume that the given expression is always valid.
//Do not use the eval built-in library function.
public class BasicCalculator_II {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String test1 = "3+2*2";
        String test2 = " 3/2 ";
        String test3 = " 3+5 / 2 ";
        String test4 = "0 - 2147483647";
        String test5 = "2*3+4";
        System.out.println(calculate(test1));
        System.out.println(calculate(test2));
        System.out.println(calculate(test3));
        System.out.println(calculate(test4));
        System.out.println(calculate(test5));


    }

    public static int calculate(String s) {
        Stack<Integer> sta = new Stack<>();
        int num = 0;
        char sig = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1){
                switch (sig) {
                    case '+':
                        sta.push(num);
                        break;
                    case '-':
                        sta.push(-num);
                        break;
                    case '*':
                        sta.push(sta.pop() * num);
                        break;
                    case '/':
                        sta.push(sta.pop() / num);
                        break;
                }
                sig = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (int number : sta) {
            res += number;
        }
        return res;
    }
}
