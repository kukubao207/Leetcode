package Array.easy;

import java.util.Arrays;

/*给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。*/
public class RemoveDuplicatesFromSortedArray {
    public static  void main(String args[]){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates_two(nums));
    }
    //双指针
    //时间复杂度O(n),空间复杂度O(1)
    public static int removeDuplicates_one(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        int j = 1;
        while(j < nums.length){
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            if(j < nums.length){
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
    //暴力
    //时间复杂度O(n*n),空间复杂度O(1)
    public static int removeDuplicates_two(int[] nums) {
        int res = 0;
        if (nums.length == 0)
            return res;
        res = 1;
        int j = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            while (j < nums.length) {
                if (nums[j] != nums[i]) {
                    nums[i + 1] = nums[j];
                    res++;
                    break;
                }
                else{
                    j++;
                }
            }
        }
        return res;
    }


}
