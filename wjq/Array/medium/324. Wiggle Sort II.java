324. Wiggle Sort II

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

思路 O(nlogn)时间，O(n)空间
先对数组排序，以中间那个数为界，分成左右两个子数组，
将左边数组倒序插入偶数位，右边数组倒序插入奇数位。

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int left_index = nums.length%2==0? nums.length/2-1:nums.length/2;
        int right_index = nums.length-1;
        int[] sorted = nums.clone();
        //将前半段倒序填入偶数位，后半段倒序填入奇数位
        for(int i=0;i<nums.length;i++)
            sorted[i] = i%2 ==0? nums[left_index--]:nums[right_index--];
        for(int i=0;i<sorted.length;i++)
            nums[i]=sorted[i];
    }
}


