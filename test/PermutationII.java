import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    private static List<List<Integer>> ans;
    public static void main(String args[]){
        int nums[] ={1,1,2};
        List<List<Integer>> l = permuteUnique(nums);
        System.out.println();
    }
    private static boolean canSwap(int[] nums, int first, int second) {
        for(int i=first;i<second;i++) {
            if(nums[i]==nums[second])
                return false;
        }
        return true;
    }
    private static void recur(int[] nums, int start) {
        if(start == nums.length) {
            List<Integer> res = new ArrayList<Integer>();
            for(int ele : nums) {
                res.add(ele);
            }
            ans.add(res);
        }
        for(int i=start;i<nums.length;i++) {
            if(canSwap(nums, start, i)) {
                int t = nums[start];
                nums[start] = nums[i];
                nums[i] = t;
                recur(nums, start+1);
                t = nums[start];
                nums[start] = nums[i];
                nums[i] = t;
            }
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        recur(nums,0);
        return ans;
    }
}
