package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. 子集 II
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
public class Subsets_II {
    public static void main(String args[]){
        int[] nums = new int[]{4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, tmp, nums, 0);
        return res;
    }
    public static void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        res.add(new ArrayList<>(tmp));
        if(start == nums.length)
            return;
        int lastUsed = Integer.MIN_VALUE;//这个lastUsed是全局存储的吗？也就是回溯的时候还是可以记录上一次的值？？？？？
        for(int i = start; i < nums.length; i++){
            if(nums[i] != lastUsed){
                tmp.add(nums[i]);
                dfs(res, tmp, nums, i + 1);
                lastUsed = tmp.get(tmp.size() - 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
