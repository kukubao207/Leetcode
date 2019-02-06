import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> l = Solution.permute(nums);
        System.out.println();
    }
    public static class Solution {
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for(int n:nums){
                List<List<Integer>> temp = new ArrayList();
                for(List<Integer> list:res){
                    for(int i=0;i<=list.size();i++) {
                        List<Integer> t = new ArrayList<>(list);
                        t.add(i,n);
                        temp.add(t);
                    }
                }
                res = temp;
            }
            return res;
        }
    }
}
