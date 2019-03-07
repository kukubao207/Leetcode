import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum {
    public static void main(String[] args){
        int[] a = {-1, 0, 1, 2, -1, -4};
        Solution.threeSum(a);
    }
    public static class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                int sum = -1*nums[i];
                Set<Integer> set = new HashSet<>();
                for(int j=i+1;j<nums.length;j++){
                    if(set.contains(sum-nums[j])){
                        List<Integer> l = new ArrayList<>();
                        l.add(-1*sum);
                        l.add(nums[j]);
                        l.add(sum-nums[j]);
                        res.add(l);
                    }
                    set.add(sum-nums[j]);
                }
            }
            return res;
        }
    }
}
