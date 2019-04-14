package Array.easy;

/**
 * Created by myh on 2019/4/14.
 */
public class SearchInsertPosition {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int val = 0;
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
            if(nums[middle] < target){
                start = middle + 1;
            }else if(nums[middle] > target){
                end = middle - 1;
            }else{
                return middle;
            }
        }
        return start;
    }

}
