import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kSum {
    public static void main(String[] args){
        int a = -4&-3;
        System.out.println(a);
        System.out.println(-4&-5);
        int[] nums = {0,0,0,0};
        Arrays.sort(nums);
        List<List<Integer>> res = kSumResult(nums,0,4,0);
        System.out.println(res.size());
    }

    public static ArrayList<List<Integer>> kSumResult(int nums[],int target,int k, int start){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(start>=nums.length)
            return res;
        if(k==2){
            int l = start, h = nums.length-1;
            while(l<h){
                if(nums[l]+nums[h]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[h]);
                    res.add(list);
                    while(l<h&&nums[l]==nums[l+1])
                        l++;
                    while(l<h&&nums[h]==nums[h-1])
                        h--;
                    l++;
                    h--;
                }else if(nums[l]+nums[h]<target)
                    l++;
                else
                    h--;
            }
            return res;
        }
        if(k>2){
            for(int i=start;i<nums.length-k+1;i++){
                ArrayList<List<Integer>> temp = kSumResult(nums, target - nums[i], k - 1, i + 1);
                if(temp!=null) {
                    for (List<Integer> l : temp) {
                        l.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while(i<nums.length-1&&nums[i]==nums[i+1]){
                    i++;
                }
            }
            return res;
        }
        return res;
    }
}