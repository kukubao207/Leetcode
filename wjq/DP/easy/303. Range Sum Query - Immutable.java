303. Range Sum Query - Immutable
        Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

        Example:
        Given nums = [-2, 0, 3, -5, 2, -1]

        sumRange(0, 2) -> 1
        sumRange(2, 5) -> -1
        sumRange(0, 5) -> -3
        Note:
        You may assume that the array does not change.
        There are many calls to sumRange function.

我的思路 建立前缀和数组时间复杂度O（n），查询时间复杂度O（1），空间复杂度O（n）
class NumArray {
    private int[] preSum;
    public NumArray(int[] nums) {
        if(nums.length==0)
            return;
        preSum = new int[nums.length];
        preSum[0]=nums[0];
        for(int i=0;i<nums.length;i++)
            if(i!=0)
                preSum[i]=preSum[i-1]+nums[i];
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return preSum[j];
        return preSum[j]-preSum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

更精简的写法
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return nums[j];
        return nums[j] - nums[i - 1];
    }
}