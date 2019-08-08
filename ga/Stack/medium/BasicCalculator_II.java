package Stack.medium;

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
    //1.只能计算个位数 哭了
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
//        String s1 = "3+2*2";
//        String s2 = " 3/2";
//        String s3 =  " 3+5 / 2 ";
//        String s4 = "42";
//        String s5 = "4 2 ";
//        String s6 = "0-2147483647";//过不了
//        System.out.println(calculate(s1));
//        System.out.println(calculate(s2));
//        System.out.println(calculate(s3));
//        System.out.println(calculate(s4));
//        System.out.println(calculate(s5));

        String s1 = "1+(2-3)*4+10/2+2*2+2+2/5";
        System.out.println(calculator(s1));

    }

    //2.第一遍先计算乘除，第二遍累加所有结果。
    //利用数字栈来保存  char sign记录上一个符号
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
    /*
    补充：https://blog.csdn.net/sinat_27908213/article/details/80273557
    （1）中缀表达式转化成后缀表达式
    * 对输入的中缀表达式从左到右遍历：
    1）如果遇到数字，直接添加到后缀表达式末尾；
    2）如果遇到运算符+、-、*、/：
    先判断栈是否为空。若是，则直接将此运算符压入栈。若不是，则查看当前栈顶元素。若栈顶元素优先级大于或等于此操作符级别，则弹出栈顶元素，将栈顶元素添加到后缀表达式中，并继续进行上述判断。如果不满足上述判断或者栈为空，将这个运算符入栈。要注意的是，经过上述步骤，这个运算符最终一定会入栈。
    3）如果遇到括号：
    如果是左括号，直接入栈。如果是右括号，弹出栈中第一个左括号前所有的操作符，并将左括号弹出。（右括号别入栈）。
    4）字符串遍历结束后，如果栈不为空，则弹出栈中所有元素，将它们添加到后缀表达式的末尾，直到栈为空。

    （2）后缀表达式计算结果
    准备一个数字栈。从左到右扫描后缀表达式，如果是数字，放入数字栈。如果是符号，从数字栈中弹出两个数字，第一个取出的数字为右运算数，第二个为左运算数，进行运算。然后将结果放进数字栈中。如此反复，直到读完整个表达式后，留在数字栈中的那个数字就是最终结果。
    * */

    //3.直接计算中缀表达式
    //包括：（，），+，-，*， /
    /*准备一个数字栈和一个符号栈
    * 从左到右遍历中缀表达式。如果遇到数字，入数字栈。
    如果遇到符号（四个运算符以及括号），跟前面的“中缀表达式转后缀表达式”过程一样，对符号栈进行处理。处理过程中，对每一个出栈的运算符：+ - * /，根据“计算后缀表达式”的方法，计算结果（跟数字栈配合）。
    如果遍历完中缀表达式后符号栈还非空，就继续出符号栈的运算符，计算，直到符号栈为空。最后数字栈剩下的数字就是结果。
    * */
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
    public static int calculator(String str) {
        //计算中缀表达式,默认输入是合法的
        Stack<Integer> number = new Stack<>();
        Stack<Character> operation = new Stack<>();
        int i = 0, j;
        int size = str.length();
        while (i < size) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                j = i;
                while (j < size && str.charAt(j) >= '0' && str.charAt(j) <= '9')
                    j++;
                number.push(Integer.parseInt(str.substring(i, j)));
                i = j;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                if (operation.isEmpty()) {
                    operation.push(str.charAt(i));
                } else {
                    while (!operation.isEmpty()) {
                        char sign = operation.peek();
                        if (getPriority(sign) >= getPriority(str.charAt(i))) {
                            myCalculate(number, sign);
                            operation.pop();
                        } else
                            break;
                    }
                    operation.push(str.charAt(i));
                }
                i++;
            } else {
                if (str.charAt(i) == '(') operation.push(str.charAt(i));
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
