package Array.easy;

/**
 * Created by myh on 2019/4/14.
 */
/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。*/
public class SearchInsertPosition {
    public static void main(String[] args){
        int[] nums = {5,5,5,6};
        int val = 5;
        System.out.println(searchInsert_two(nums, val));
    }
    //遍历
    //时间复杂度O(n),空间复杂度O(1)
    public static int searchInsert_one(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }else if(nums[i] < target){
                continue;
            }else{
                return i;
            }
        }
        return nums.length;
    }
    //二分查找
    //时间复杂度O(log(n)),空间复杂度O(1)
    public static int searchInsert_two(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int middle = (end + start) / 2;
            if(nums[middle] >= target){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        return start;
    }

}
