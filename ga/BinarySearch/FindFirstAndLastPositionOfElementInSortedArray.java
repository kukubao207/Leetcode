package BinarySearch;

//34. Find First and Last Position of Element in Sorted Array
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//如果数组中不存在目标值，返回 [-1, -1]。
//
//示例 1:
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]

import java.util.Arrays;

//这一题也就是找到第一次出现target的数和最后一次出现target的数
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String args[]){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int first = firstLarge(nums, target);
        int last = lastEqual(nums, target);
        return new int[]{first, last};
    }
    public static int firstLarge(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] >= target)
                r = mid - 1;
            else if(nums[mid] < target)
                l = mid + 1;
        }
        if(l < nums.length && nums[l] == target)
            return l;
        return -1;
    }

    public static int lastEqual(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] <= target)
                l = mid + 1;
            else if(nums[mid] > target)
                r = mid - 1;
        }
        if(r >= 0 && nums[r] == target)
            return r;
        return -1;
    }
}
