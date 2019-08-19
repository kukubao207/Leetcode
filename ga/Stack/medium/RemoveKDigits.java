package Stack.medium;

import java.util.Stack;

//402. Remove K Digits
//Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
//
//Note:
//The length of num is less than 10002 and will be ≥ k.
//The given num does not contain any leading zero.
//Example 1:
//
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//Example 2:
//
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//Example 3:
//
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing which is 0.
public class RemoveKDigits {
    public static void test(){
        String num = "145231";
        int k = 3;
        System.out.print(removeKdigits(num, k));
    }
    //维护单调栈+贪心（能删几个就删几个 让最高位尽量小）
    //这道题不是连续删除 可以间隔删除 相对顺序不变即可
    public static String removeKdigits(String num, int k) {
        //贪心算法 + 栈
        if(k >= num.length() || num.length() == 0)
            return "0";
        //栈顶始终是最大值
        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0)- '0');
        for(int i = 1; i < num.length(); i++){
            int n = num.charAt(i) - '0';
            //可能好几个值都比当前值大，那么我们就在k允许的情况下，去去除它。
            while(!stack.isEmpty() && k > 0 && n < stack.peek()){
                stack.pop();
                k--;
            }
            //不等于0可以添加进去,
            //等于0，栈不为空可以填进去，
            if(n != 0 || !stack.isEmpty())
                stack.push(n);
        }
        //56789这种情况，前面一直比后面小，那就去除栈顶，谁让栈顶最大
        while(k > 0)
        {
            k--;
            stack.pop();
        }
        //10，k=1(当n = 0时，满足条件，去掉1，但n为0，且为空。)
        if(stack.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        //从后往前添加所以我们要逆序
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        test();
    }
}
