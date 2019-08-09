package Stack.hard;

import java.util.Stack;

//224. Basic Calculator
//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
//
//Example 1:
//
//Input: "1 + 1"
//Output: 2
//Example 2:
//
//Input: " 2-1 + 2 "
//Output: 3
//Example 3:
//
//Input: "(1+(4+5+2)-3)+(6+8)"
//Output: 23
//Note:
//You may assume that the given expression is always valid.
//Do not use the eval built-in library function.
public class BasicCalculator {
    //求中缀表达式
    public static int getPriority(char ch){
        //获取优先级
        if(ch == '(')
            return 1;
        else if(ch == '+' || ch == '-')
            return 2;
        else if(ch == '*' || ch == '/')
            return 3;
        else if(ch == ')')
            return 4;
        else
            return -1;
    }
    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        //计算中缀表达式,默认输入是合法的
        Stack<Integer> number = new Stack<>();
        Stack<Character> operation = new Stack<>();
        int i = 0, j;
        int size = s.length();
        while (i < size) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                j = i;
                while (j < size && s.charAt(j) >= '0' && s.charAt(j) <= '9')
                    j++;
                number.push(Integer.parseInt(s.substring(i, j)));
                i = j;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (operation.isEmpty()) {
                    operation.push(s.charAt(i));
                } else {
                    while (!operation.isEmpty()) {
                        char sign = operation.peek();
                        if (getPriority(sign) >= getPriority(s.charAt(i))) {
                            myCalculate(number, sign);
                            operation.pop();
                        } else
                            break;
                    }
                    operation.push(s.charAt(i));
                }
                i++;
            } else {
                if (s.charAt(i) == '(') operation.push(s.charAt(i));
                else {//str.charAt(i) == ')'
                    while (operation.peek() != '(') {
                        char sign = operation.peek();
                        //计算
                        myCalculate(number, sign);
                        operation.pop();
                    }
                    operation.pop();
                }
                i++;
            }
        }
        //遍历完后，若栈非空，弹出所有元素
        while (!operation.isEmpty()) {
            char sign = operation.peek();
            //计算
            myCalculate(number, sign);
            operation.pop();
        }
        return number.peek();
    }

    public static void myCalculate(Stack<Integer> number, char sign){
        //计算
        int num2 = number.pop();
        int num1 = number.pop();
        if(sign == '+')
            number.push(num1 + num2);
        else if(sign == '-')
            number.push(num1 - num2);
        else if(sign == '*')
            number.push(num1 * num2);
        else if(sign == '/')
            number.push(num1 / num2);
    }
}
