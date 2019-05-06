package TwoPointer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18. 4Sum
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//注意：
//
//答案中不可以包含重复的四元组。
//
//示例：
//
//给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
public class FourSum {
    //做完这个再考虑kSum吧
    public static void main(String args[]){
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    //注意去重
    //kSum问题
    //nums是排序过的数组
    public static List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(start >= len) return res;
        if(k == 2){
            int l = start;
            int r = len - 1;
            while(l < r){
                if(nums[l] + nums[r] < target){//去重
                    while(l < r && nums[l + 1] == nums[l])
                        l++;
                    l++;
                }else if(nums[l] + nums[r] > target){
                    while(l < r && nums[r - 1] == nums[r])
                        r--;
                    r--;
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[l],nums[r])));//转换为arraylist
                    while(l < r && nums[l + 1] == nums[l])
                        l++;
                    while(l < r && nums[r - 1] == nums[r])
                        r--;
                    l++;
                    r--;
                }
            }
        }
        if(k > 2){
            for(int i = start; i < len - k + 1; i++){
                if(i > start && nums[i] == nums[i - 1]) continue;//去重
                List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if(temp != null){
                    for(List<Integer> l : temp){
                        l.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
            }
        }
        return res;
    }
}
