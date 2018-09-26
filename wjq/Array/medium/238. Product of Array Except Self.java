238. Product of Array Except Self

Given an array nums of n integers where n > 1,  
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? 
(The output array does not count as extra space for the purpose of space complexity analysis.)

题意
给定一个数组，求出数组每一个位置，除该位置外其他所有元素的乘积，不允许使用除法，O(n)时间，O(1)空间

思路
对于数组的每一位，其他所有位置的乘积可以分为 该元素左边的乘积 和 该元素右边的乘积， 这样划分之后，就可以节省重复计算乘积的时间。
而每一位的结果，就等于该位左边乘积 乘以 右边乘积。
举个栗子，对于[2,3,4,5]
	    2     3     4     5
left    1     2    2*3  2*3*4 
right 3*4*5  4*5    5     1   
结果    60    40    30    24

代码
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int left=1;
        for(int i=0;i<n;i++){
            if(i>0)
                left*=nums[i-1];
            ans[i]=left;
        }
        int right=1;
        for(int i=n-1;i>=0;i--){
            if(i<n-1)
                right*=nums[i+1];
            ans[i]*=right;
        }
        return ans;
    }
}