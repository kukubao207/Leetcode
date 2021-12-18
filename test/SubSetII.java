import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
    public static void main(String[] args){
        int[] a = {1,2,2};
        List<List<Integer>> res=  Solution.subsetsWithDup(a);
        System.out.println(res.size());
    }
    public static class Solution {
        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            Arrays.sort(nums);
            subsets(res,temp,nums,0);
            return res;
        }
        public static void subsets(List<List<Integer>> res,List<Integer> temp,int[] nums,int start){
            res.add(new ArrayList<>(temp));
            System.out.println("add to res:" + temp);
            for(int i=start;i<nums.length;i++){
                if(i>start&&nums[i]==nums[i-1]) {
                    continue;
                }
                temp.add(nums[i]);
                subsets(res,temp,nums,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
