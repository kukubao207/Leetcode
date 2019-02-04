33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

题意，
以一个点旋转某个排好序的数组，要求在O(lgN)时间内找出这个数组的某个数的下标。
解题思路
很显然，这题是要用二分查找的，但由于不是排好序的数组，普通的二分查找不能够应用在本题。
因此需要分析这种数组有什么特点。
假设原始数组为[1,2,3,4,5,6,7]
[2,3,4,5,6,7,1] mid=3左边为升序
[3,4,5,6,7,1,2] mid=3左边为升序
[4,5,6,7,1,2,3] mid=3左边为升序
[5,6,7,1,2,3,4] mid=3右边为升序
[6,7,1,2,3,4,5] mid=3右边为升序
[7,1,2,3,4,5,6] mid=3右边为升序

很显然，在这种数组中 mid=(left+right)/2的位置的数，左边或者右边一定有一边是绝对升序的。
比如例子中的mid=3，左边[0,3]升序,右边[3,6]不为升序
那就可以以这种特性进行二分查找
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<nums[right]){
                if(nums[mid]<target&&nums[right]>=target)
                    left = mid+1;
                else
                    right = mid-1;
            }else if(nums[mid]>=nums[right]){
                if(nums[mid]>target&&nums[left]<=target)
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}