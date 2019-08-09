package Stack.hard;

import java.util.Stack;

//150. Evaluate Reverse Polish Notation
//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Note:
//
//Division between two integers should truncate toward zero.
//The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
//Example 1:
//
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//Example 2:
//
//Input: ["4", "13", "5", "/", "+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//Example 3:
//
//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//Output: 22
//Explanation:
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        String[] t1 = {"0"};
        System.out.println(evalRPN(t1));
        String[] t2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(t2));
        String[] t3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(t3));
    }
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 0 || tokens == null)
            return 0;
        Stack<Integer> s = new Stack<>();
        for (String t : tokens) {
            switch (t) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                case "-":
                    s.push( -s.pop() + s.pop());
                    break;
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                case "/":
                    Integer n2 = s.pop();
                    Integer n1 = s.pop();
                    s.push( n1 / n2);
                    break;
                default:
                    s.push(Integer.parseInt(t));
                    break;
            }
        }
        return s.peek();
    }
}
