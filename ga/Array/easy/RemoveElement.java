package Array.easy;

import java.util.Arrays;

/**
 * Created by myh on 2019/4/13.
 */
/*给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。*/
public class RemoveElement {
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement_one(nums, val));
    }
    //i存放需要被替换位置，j存放需要替换的索引
    //时间复杂度O(2n)，空间复杂度O(1)
    public static int removeElement_one(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return i;
    }

    //i存放需要被替换位置，j存放需要替换的索引(nums[i]和nums[j]同时做判断)
    //时间复杂度O(2n)，空间复杂度O(1)
    public static int removeElement_two(int[] nums, int val) {
        int i = 0;
        int j = 1;
        int flag = 0;
        int temp = 0;
        while(i < nums.length && j < nums.length){
            flag++;
            while(i < nums.length && nums[i] != val){
                i++;
            }
            if(flag == 1)
                j = i + 1;
            while(j < nums.length && nums[j] == val){
                j++;
            }
            if(i < nums.length && j < nums.length){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return i;
    }
    //将val元素放置于最后一个位置
    //时间复杂度O(n),空间复杂度O(1)
    public static int removeElement_three(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            if( nums[i] == val){
                nums[i] = nums[n - 1];
                n--;
            }else{
            i++;
            }
        }
        return i;
    }
}
