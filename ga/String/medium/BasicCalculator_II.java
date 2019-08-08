package String.medium;

import java.util.HashMap;
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
    public static void main(String[] args){
        test();
    }
    //只能计算个位数 哭了
    //位数多有点麻烦  多重循环了
    public static int calculate(String s){
        int num = 0;
        s = s.trim();
        s = s.replaceAll(" ", "");
        for(int i = 0; i < s.length(); i++){
             if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                if(s.charAt(i) == '*')
                    num = Integer.parseInt(""+s.charAt(i - 1)) * Integer.parseInt(""+s.charAt(i + 1));
                if(s.charAt(i) == '/'){
                    num = Integer.parseInt(""+s.charAt(i - 1)) / Integer.parseInt(""+s.charAt(i + 1));
                }
                if(i - 1 > 0 && i + 1 < s.length() - 1){
//                    System.out.println(s.substring(0, i - 1) + num + s.substring(i + 2, s.length()));
                    return calculate(s.substring(0, i - 1) + num + s.substring(i + 2, s.length()));
                }
                else if(i - 1 > 0){
//                    System.out.println(s.substring(0, i - 1) + num);
                    return calculate(s.substring(0, i - 1) + num);
                }
                else if(i + 1 < s.length() - 1){
//                    System.out.println(num + s.substring(i + 2, s.length()));
                    return calculate(num + s.substring(i + 2, s.length()));
                }
                else
                    return num;
            }
        }
        int sum = 0;
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+'){
                sum += Integer.parseInt(""+s.charAt(i - 1)) + Integer.parseInt(""+s.charAt(i + 1));
                flag = true;
            }
            else if(s.charAt(i) == '-'){
                sum += Integer.parseInt(""+s.charAt(i - 1)) - Integer.parseInt(""+s.charAt(i + 1));
                flag = true;
            }
        }
        if(flag)
            return sum;
        else return Integer.parseInt("" + s);
    }

    public static void test(){
        String s1 = "3+2*2";
        String s2 = " 3/2";
        String s3 =  " 3+5 / 2 ";
        String s4 = "42";
        String s5 = "4 2 ";
        String s6 = "0-2147483647";//过不了
        System.out.println(calculate(s1));
        System.out.println(calculate(s2));
        System.out.println(calculate(s3));
        System.out.println(calculate(s4));
        System.out.println(calculate(s5));
    }

    public static int calculate1(String s){
        // 保存上一个符号，初始为 +
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        // 保存当前数字，如：12是两个字符，需要进位累加
        int num = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur >= '0'){
                num = num * 10 - '0' + cur;// 记录当前数字。先减，防溢出
            }
            if((cur < '0' && cur != ' ' )|| i == s.length() - 1){
                // 判断上一个符号是什么
                switch (sign){
                    // 当前符号前的数字直接压栈
                    case '+': stack.push(num);break;
                    // 当前符号前的数字取反压栈
                    case '-': stack.push (-num);break;
                    // 数字栈栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                    case '*': stack.push(stack.pop() * num);break;
                    // 数字栈栈顶数字出栈，与当前符号前的数字相除，结果值压栈
                    case '/': stack.push(stack.pop() / num);break;
                }
                // 记录当前符号
                sign = cur;
                // 数字清零
                num = 0;
            }
        }
        // 将栈内剩余数字累加，即为结果
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

}
