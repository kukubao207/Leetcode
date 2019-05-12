package PermutationAndCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//46. Permutations
//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]

public class Permutations {
    public static void main(String args[]){
        int[] nums = new int[]{1,2,3};
        System.out.println(permute1(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        fullPermutation( res, tmp, nums);
        return res;
    }
    //递归
    public static void fullPermutation(List<List<Integer>> res, List<Integer> tmp, int[] nums){
        if(tmp.size() == nums.length)
            res.add(new ArrayList<Integer>(tmp));
        else if(tmp.size() > nums.length){
            return;
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(!tmp.contains(nums[i])){//去掉重复数
                    tmp.add(nums[i]);
                    fullPermutation(res, tmp, nums);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    //[[]] → [[1]] → [[1,2],[2,1]] → [[3,1,2],[1,3,2],[1,2,3],[3,2,1],[2,3,1],[2,1,3]]
    //迭代
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> tmp = new ArrayList<>();//临时数组
            for(int j = 0; j < res.size(); j++){
                List<Integer> list = res.get(j);
                for(int k = 0; k <= list.size(); k++){//存放要插入的位置
                    List<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    tmp.add(t);
                }
            }
            res = tmp;
        }
    return res;
    }
}
