package TwoPointer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class ThreeSum {
    public static void main(String args[]){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum_one(nums));
    }

    public static List<List<Integer>> twoSum(int nums[], int l ,int r, int target){
        int i = l;
        int j = r;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while(l < r){
            if(nums[l] + nums[r] < target)
                l++;
            else if(nums[l] + nums[r] > target)
                r--;
            else{
                List<Integer> subRes = new ArrayList<Integer>();
                subRes.add(-target);
                subRes.add(nums[l]);
                subRes.add(nums[r]);
                res.add(subRes);
                l++;
                r--;
            }
        }
        return res;
    }

    //三数之和问题可以转换为二数之和问题
    //a+b+c = 0 --> a+b = -c
    //时间复杂度O(n*n)
    //空间复杂度O(n*n)
    public static List<List<Integer>> threeSum(int nums[]){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
            List subRes = twoSum(nums, i + 1, nums.length - 1, -nums[i]);
            res.addAll(subRes);
        }
        List<List<Integer>> finalRes = new ArrayList<List<Integer>>();
        if(res.size() > 0)
            finalRes.add(res.get(0));
        for(int i = 1; i < res.size(); i++){
            int j = i - 1;
            for(j = i - 1; j >= 0; j--){
                if(res.get(i).equals(res.get(j))){
                    break;
                }
            }
            if(j == -1){
                finalRes.add(res.get(i));
            }
        }
        return finalRes;
    }




    //关键在于循环里面的二次去重,解决超时问题(还是转换成两数相加问题)
    public static List<List<Integer>> threeSum_one(int nums[]){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i > 0 && nums[i] == nums[i - 1])//第一次去重
                continue;
            int l =  i + 1;
            int r = len - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0){
                    while(l < r && nums[l + 1] == nums[l])//二次去重
                        l++;
                    l++;
                }
                else if(sum > 0){
                    while(l < r && nums[r - 1] == nums[r])
                        r--;
                    r--;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l + 1] == nums[l])
                        l++;
                    while(l < r && nums[r - 1] == nums[r])
                        r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }

}
