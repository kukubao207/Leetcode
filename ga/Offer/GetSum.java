package Offer;

/**
 *不用加减乘除做加法
 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class GetSum {
    public int Add(int num1,int num2) {
        int num = 0;
        int carry = 0;
        do{
            num = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = num;
            num2 = carry;
        }while(carry != 0);
        return num;
    }
}
