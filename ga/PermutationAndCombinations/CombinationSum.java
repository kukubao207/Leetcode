package PermutationAndCombinations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39. Combination Sum
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
//
//说明：
//
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。
//示例 1:
//
//输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//示例 2:
//
//输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
public class CombinationSum {
    public static void main(String args[]){
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        Arrays.sort(candidates);
        System.out.println(combinationSum(candidates, target));
    }
    //temp是已经选取的数字
    public static void backtrack(int[] candidates, List<List<Integer>> res, List<Integer> tmp, int target, int start){
        if(target == 0){
            res.add(new ArrayList<Integer>(tmp));//之前写res.add(tmp)的时候res里面的内容一直被覆盖掉，不知道为啥？？？
        }
        else if(target < 0)
            return;
        else{
            for(int i = start; i < candidates.length; i++){
                if(candidates[i] > target)
                    return;
                tmp.add(candidates[i]);
                backtrack(candidates, res, tmp, target - candidates[i], i);
                tmp.remove(tmp.size() - 1);//返回之前的节点再去重新搜索满足条件
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, res, tmp, target, 0);
        return res;
    }
}
