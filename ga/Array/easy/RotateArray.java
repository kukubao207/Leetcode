package Array.easy;
//189. Rotate Array
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//
//输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//示例 2:
//
//输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//说明:
//
//尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
//要求使用空间复杂度为 O(1) 的原地算法。

import java.util.Arrays;

public class RotateArray {
    public static void main(String args[]){
        int[] nums = new int[]{1};
        int k = 3;
        System.out.println(Arrays.toString(rotate_two(nums, k)));
    }
    //时间复杂度O(k*n)
    //空间复杂度O(1)
    public static int[] rotate(int[] nums, int k) {
        int temp = 0;
        k = k % nums.length;
        for(int i = 0; i < k; i++){
            temp = nums[nums.length - 1];
            for(int j = nums.length - 2; j >= 0; j--){
               nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
        return nums;
    }
    //翻转
    //前n-k部分翻转  后k半部分翻转  整体翻转
    //时间复杂度O(n),空间复杂度O(1)
    public static int[] rotate_one(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse (nums, nums.length - k, nums.length - 1);
        reverse(nums, 0 ,nums.length - 1);
        return nums;
    }
    public static void reverse(int[] nums, int left, int right) {
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    //利用(i+k)%n等于新i的思路，不过这次是每次调换一个元素，后一个元素的调换基于上一个的位置。
    //就是在一个环中，给定一个k，不一定能够把环上每一个数字都过一遍，如果遇到了已经找到的数，那么需要把指针往前挪一个（1，2，3，4，5，6）
    //时间复杂度O(n),空间复杂度O(1)
    public static int[] rotate_two(int[] nums, int k) {
        int length = nums.length;
        int start = 0;//每一轮开始的index
        int i = 0;
        int cur = nums[i];
        int cnt = 0;
        while(cnt++ < length){
            i = (i + k) % length;
            int temp = nums[i];
            nums[i] = cur;
            if(i == start){
                start++;
                i++;
                if(i < nums.length)
                    cur = nums[i];
            }else{
                cur = temp;
            }
        }
        return nums;
    }
}
