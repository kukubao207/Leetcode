package BinarySearch;
//33. Search in Rotated Sorted Array
/*
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
*
* 示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
*
* */
public class SearchInRotatedSortedArray {
    public static void main(String args[]){
        int[] nums = new int[]{3,1};
        int target = 1;
        System.out.println(search(nums,target));
    }
    //这个时间复杂度是多少啊  还是log(n)吗？？？
    //这个可以看一下小王的D:\github\Leetcode\wjq\Array\medium\33. Search in Rotated Sorted Array.java
    public static int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null)
            return -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            if(nums[l] < nums[r]){//排序数组，二分查找
                return binarySearch(l, r, nums, target);
            }
            int mid = (l + r) / 2;
            if(nums[l] <= nums[mid]){//说明前半段有序（只要数组的开始数小于结尾数就是有序的）
                if(nums[l] <= target && target <= nums[mid]){//target在有序数组
                    return binarySearch(l, mid, nums, target);
                }else{//target在无序数组
                    l = mid + 1;
                }
            }else{//后一段有序
                if(nums[mid] <= target && target <= nums[r]){//target在有序数组
                    return binarySearch(mid, r, nums, target);
                }else{//target在无序数组
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int l ,int r, int[] nums, int target){
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }


    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] < nums[mid]){//前半部分有序
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else if(nums[left] > nums[mid]){//后半部分有序
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                left = left + 1;
            }
        }
        return -1;
    }

}
