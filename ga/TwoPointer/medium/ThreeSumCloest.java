package TwoPointer.medium;

import java.util.Arrays;

//16. 3Sum Closest
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
public class ThreeSumCloest {
    public static void main(String args[]){
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));

    }
    //先排序, 然后遍历, 将三数之和改变为二数之和，然后内部使用双指针
    //时间复杂度O(n*n)，空间复杂度O(1)
    public static int threeClose(int[] nums, int n, int target, int l ,int r) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        while(l < r){
            if(Math.abs(nums[l] + nums[r] + n - target) < min){
                min = Math.abs(nums[l] + nums[r] + n - target);
                res = nums[l] + nums[r] + n;
            }
            if(nums[l] + nums[r] + n > target)
                r--;
            else if(nums[l] + nums[r] + n < target)
                l++;
            else
                return target;
        }
        return res;
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            int subRes = threeClose(nums, nums[i], target, i + 1, nums.length - 1);
            int m = Math.abs(subRes - target);
            if(m < min){
                min = m;
                res = subRes;
            }
        }
        return res;
    }
}
