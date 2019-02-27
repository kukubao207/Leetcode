172. Factorial Trailing Zeroes

        Given an integer n, return the number of trailing zeroes in n!.

        Example 1:

        Input: 3
        Output: 0
        Explanation: 3! = 6, no trailing zero.
        Example 2:

        Input: 5
        Output: 1
        Explanation: 5! = 120, one trailing zero.
        Note: Your solution should be in logarithmic time complexity.



思路
首先
0是由2*5=10产生，有多少个5的因子，结尾就有多少个0

对于1到23 之间，有多少个5因子？
23/5 = 4
对于1到100 之间，有多少个5的因子？
100/5 =20
但是注意一下 25=5*5，其实1到100应该有21个5的因子。

也就是说，
从1到n
我们可以计算出5的因子数量为
n/5+n/(5*5)+n/(5*5*5) .........

class Solution {
    public int trailingZeroes(int n) {
        int r=0;
        while(n>0){
            n/=5;
            r+=n;
        }
        return r;
    }
}
