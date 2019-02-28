201. Bitwise AND of Numbers Range

        Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

        Example 1:

        Input: [5,7]
        Output: 4
        Example 2:

        Input: [0,1]
        Output: 0

题意
给定一个整数范围，求这个范围内所有数相&的结果

思路
这只和 起始数和 结束数的 最左相同位（二进制）相关

class Solution {
    public int rangeBitwiseAnd(int m, int n) {

        if (m==n)
            return m;

        int fac=1;
        while(m!=n){
            m>>=1;
            n>>=1;
            fac<<=1;
        }
        return m*fac;
    }
}