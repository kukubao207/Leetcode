152. Maximum Product Subarray

        Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

        Example 1:

        Input: [2,3,-2,4]
        Output: 6
        Explanation: [2,3] has the largest product 6.
        Example 2:

        Input: [-2,0,-1]
        Output: 0
        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


思路
这道题显然是用DP
我能想到
DP数组应该要保存 以i为结尾这个这个元素的最大乘积，
然后到i+1的时候， 又会想，如果i+1是负数，那么应该希望前面的i提供给我一个最小的数，这样乘起来才能最大，
如果i+1是证书，那么前面的i提供给我一个最大的数，就可以乘起来最大。

class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int[] min_dp = new int[nums.length];        //以该元素结尾能向后面提供的最小乘积
        int[] max_dp = new int[nums.length];        //以该元素结尾能向后面提供的最大乘积
        min_dp[0]=nums[0];
        max_dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
                min_dp[i] = Math.min(nums[i],min_dp[i-1]*nums[i]);
                max_dp[i] = Math.max(nums[i],max_dp[i-1]*nums[i]);
            }else{
                min_dp[i] = Math.min(nums[i],max_dp[i-1]*nums[i]);
                max_dp[i] = Math.max(nums[i],min_dp[i-1]*nums[i]);
            }
            ans = Math.max(ans,max_dp[i]);
        }
        return ans;
    }
}


优化空间
class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int max_value=nums[0];
        int min_value=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = max_value;
                max_value=min_value;
                min_value=temp;
            }
            max_value = Math.max(max_value*nums[i],nums[i]);
            min_value = Math.min(min_value*nums[i],nums[i]);
            ans = Math.max(ans,max_value);
        }
        return ans;
    }
}