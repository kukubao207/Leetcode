package PermutationAndCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40. Combination Sum II
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用一次。
//
//说明：
//
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。
//示例 1:
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//示例 2:
//
//输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
public class CombinationSumII {
    public static void main(String args[]){
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum2(candidates, target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, tmp, 0);
         return res;
    }
    public static void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start){
        if(target == 0){
//            if(!res.contains(tmp))//这个数组是可重复元素的数组，与上一题不一样
            res.add(new ArrayList<Integer>(tmp));
        }
        else if(target < 0)
            return;
        else{
            int lastUsed = Integer.MIN_VALUE;
            for(int i = start; i < candidates.length; i++){
                if(candidates[i] > target)
                    return;
                if(candidates[i] == lastUsed)
                    continue;
                tmp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], res, tmp, i + 1);
                lastUsed = tmp.get(tmp.size() - 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
