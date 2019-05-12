package backtracking;

import java.util.ArrayList;
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
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        fullPermutation( res, tmp, nums);
        return res;
    }

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
}
