package Math.medium;
//29. Divide Two Integers
//Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
//
//Return the quotient after dividing dividend by divisor.
//
//The integer division should truncate toward zero.
//
//Example 1:
//
//Input: dividend = 10, divisor = 3
//Output: 3
//Example 2:
//
//Input: dividend = 7, divisor = -3
//Output: -2
//Note:
//
//Both dividend and divisor will be 32-bit signed integers.
//The divisor will never be 0.
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
public class DivideTwoIntegers {
    //使用位运算思想。每次都从2^0 + 2^1 + ...开始逼近，当快要接近被除数时。再从2^0 + 2^1 + ...开始逼近。直到不能更近为止。
    //我们可以以100 / 3为例
    //2^n是1，2，4，8...2^31这种数，当n为31时，这个数特别大，100 / 2^n是一个很小的数，肯定是小于3的，所以循环下来，
    //当n = 5时，100 / 32 = 3, 刚好是大于等于3的，这时我们将100 - 32 * 3 = 4，也就是减去了32个3，接下来我们再处理4，同样手法可以再减去一个3
    //所以一共是减去了33个3，所以商就是33
    //这其中得处理一些特殊的数，比如divisor是不能为0的，Integer.MIN_VALUE和Integer.MAX_VALUE
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;//是否为负数
        negative = (dividend ^ divisor) < 0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {//找出足够大的数2^n * divisor  //t >> i (t / 2^i)
                result += 1 << i;//将结果加上2^n
                t -= d << i;//将被除数减去2^n * divisor  //d << i (d * 2^i)
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}

