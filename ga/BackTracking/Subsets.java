package BackTracking;

import java.util.ArrayList;
import java.util.List;

//78. 子集
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(res, tmp, nums, 0);
        return res;
    }
    public static void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        res.add(new ArrayList<Integer>(tmp));
        if(start == nums.length){
            return;
        }
        for(int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            dfs(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
