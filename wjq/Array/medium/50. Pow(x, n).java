50. Pow(x, n)
        Implement pow(x, n), which calculates x raised to the power n (xn).

        Example 1:

        Input: 2.00000, 10
        Output: 1024.00000
        Example 2:

        Input: 2.10000, 3
        Output: 9.26100
        Example 3:

        Input: 2.00000, -2
        Output: 0.25000
        Explanation: 2-2 = 1/22 = 1/4 = 0.25
        Note:

        -100.0 < x < 100.0
        n is a 32-bit signed integer, within the range [−231, 231 − 1]

注意两种特殊情况
x=1  n=Integer.MIN_VALUE
x=-1 n=Integer.MIN_VALUE
注意n为负数的情况
class Solution {
    public double myPow(double x, int n) {
        if((!(x==-1||x==1))&&n==Integer.MIN_VALUE)
            return 0;
        double res=1;
        if(n<0){
            n*=-1;
            x=1/x;
        }
        while(n>0){
            if(n%2==1)              //如果幂是一个奇数
                res*=x;             //给res乘上一个x
            x=x*x;
            n=n/2;
        }
        return res;
    }
}