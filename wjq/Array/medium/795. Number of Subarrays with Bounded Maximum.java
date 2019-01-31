795. Number of Subarrays with Bounded Maximum

We are given an array A of positive integers, and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.

Example :
Input:
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
Note:

L, R  and A[i] will be an integer in the range [0, 10^9].
The length of A will be in the range of [1, 50000].

思路
动态规划
lessThanLeft 计数保存了 左边界到这小于L的数量
lessAndEqualThanRight 计数 保存了 左边界到这小于等于R的数量
这两者的差就代表 基于当前的num，往前构造，可以构造出的满足要求的区间数量。
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int lessThanLeft = 0,lessAndEqualThanRight = 0,res=0;
        for(int num:A){
            if(num<L){
                lessThanLeft++;
            }else{
                lessThanLeft=0;
            }
            if(num<=R){
                lessAndEqualThanRight++;
            }else{
                lessAndEqualThanRight=0;
            }
            res += lessAndEqualThanRight-lessThanLeft;
        }
        return res;
    }
}