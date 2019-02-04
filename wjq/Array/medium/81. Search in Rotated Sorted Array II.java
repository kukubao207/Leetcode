81. Search in Rotated Sorted Array II
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

原始数组[0,0,1,2,2,5,6]
[0,1,2,2,5,6,0]  mid=3 左边升序
[1,2,2,5,6,0,0]  mid=3 左边升序
[2,2,5,6,0,0,1]  mid=3 左边升序
[2,5,6,0,0,1,2]  mid=3 右边升序
[5,6,0,0,1,2,2]  mid=3 右边升序
[6,0,0,1,2,2,5]  mid=3 右边升序

若中间值小于最右值，右边绝对升序；
若中间值大于最右值，左边绝对升序；
若中间值等于最右值，最右值去掉（去重并不影响，因为数组中仍然有该元素），重新判断。

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid]<nums[right]){
                if(nums[mid]<target&&nums[right]>=target)
                    left = mid+1;
                else
                    right = mid-1;
            }else if(nums[mid]>nums[right]){
                if(nums[mid]>target&&nums[left]<=target)
                    right = mid-1;
                else
                    left = mid+1;
            }
            else
                right--;
        }
        return false;
    }
}
