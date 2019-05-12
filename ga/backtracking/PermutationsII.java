package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47. Permutations II
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//示例:
//
//输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class PermutationsII {
    public static void main(String args[]){
        int[] nums = new int[]{3,0,3};
        System.out.println(permuteUnique1(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        fullPermutation( res, tmp, nums,used);
        return res;
    }
    //在全排列I解法的基础上多了一个去重
    //数组要先排序
    // 有两部分的去重
    //第一部分是已经使用过的数字不能再使用（used）
    //第二部分是上一个数字和下一个数字相等时也是重复的(lastUsed)
    public static void fullPermutation(List<List<Integer>> res, List<Integer> tmp, int[] nums,int[] used){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        else{
            int lastUsed = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++){
                if(used[i] == 0 && nums[i] != lastUsed){//两部分去重
                    used[i] = 1;
                    tmp.add(nums[i]);
                    fullPermutation(res, tmp, nums,used);
                    lastUsed = nums[i];
                    used[i] = 0;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    //[[]] → [[1]] → [[1,1] → [[2,1,1],[1,2,1],[1,1,2]
    //迭代
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> tmp = new ArrayList<>();
            for(int j = 0; j < res.size(); j++){
                List<Integer> list = res.get(j);
                for(int k = 0; k <= list.size(); k++){
                    if(k > 0 && nums[i] == list.get(k - 1))//去重
                        continue;
                    List<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    if(!tmp.contains(t))//去重
                        tmp.add(t);
                }
            }
            res = tmp;
        }
        return res;
    }
}
