16. 3Sum Closest

        Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

        Example:

        Given array nums = [-1, 2, 1, -4], and target = 1.

        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).



class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE,ans=0;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1,h=nums.length-1;
            while(l<h){
                int add_sum = nums[i] + nums[l] + nums[h];
                if(Math.abs(target-add_sum)<diff){
                    diff=Math.abs(target-add_sum);
                    ans = add_sum;
                }
                if(target==add_sum){
                    return target;
                }else if(add_sum<target){
                    l++;
                }else{
                    h--;
                }
            }
        }
        return ans;
    }
}