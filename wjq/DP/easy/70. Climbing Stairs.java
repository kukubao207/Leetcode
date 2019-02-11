70. Climbing Stairs
        You are climbing a stair case. It takes n steps to reach to the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Note: Given n will be a positive integer.

        Example 1:

        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
        Example 2:

        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step

我的思路
class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0]=1;
        f[1]=1;
        for(int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }

}

别人的思路（C++）
直接用公式求解Fibonacci数列（斐波那契数列）
int climbStairs(int n) {
    n++;
    double root5 = pow(5, 0.5);
    double result = 1/root5*( pow((1+root5)/2, n) - pow((1-root5)/2, n) );
    return (int)(result);
}