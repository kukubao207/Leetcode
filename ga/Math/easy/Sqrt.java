package Math.easy;

import java.util.ArrayList;
import java.util.Iterator;

//69. Sqrt(x)
//Implement int sqrt(int x).
//
//Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
//Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
//
//Example 1:
//
//Input: 4
//Output: 2
//Example 2:
//
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since
//             the decimal part is truncated, 2 is returned.
public class Sqrt {
    //一个数的平方根最多不会超过它的一半
    //如果一个数的一半的平方大于它自己，那么这个数的取值范围 a >= 4或a <= 0
    //https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
    //1.二分法
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }
    //2.牛顿法
    // f(x) = x^2 - a
    // 求解 a 的平方根, 即求解 f(x) = 0 的解
    // f(x) 约为 f(x0) + (x - x0) * f'(x0);
    // 令 f(x) = 0   =>   x = (x0 + a/x0) /2	=>    得到该迭代公式.
    public int mySqrt1(int x) {
        long x0 = x;
        while (x0 * x0 > x) {
            x0 = (x0 + x / x0) / 2;
        }
        return (int)x0;
    }

}
