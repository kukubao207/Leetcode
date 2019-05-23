package TwoPointer.medium;
//209. 长度最小的子数组
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
//
//示例:
//
//输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
//进阶:
//
//如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
public class MinimumSizeSubarraySum {
    //这个时间复杂度是O(nlogn)吗？？？
    //滑动窗口模块，i，j分别记录窗口的起始位置，如果窗口的和大于s，则i++，如果和小于s，则j++
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = -1;
        int sum = 0;
        int len = nums.length + 1;
        while(i < nums.length){
            if(j + 1 < nums.length && sum < s){
                j++;
                sum = sum + nums[j];
            }else{
                sum = sum - nums[i];
                i++;
            }
            if(sum >= s)
                len = Math.min(len, j - i + 1);
        }
        if(len == nums.length + 1)
            return 0;
        return len;
    }
}
