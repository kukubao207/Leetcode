209. Minimum Size Subarray Sum
        Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

        Example:

        Input: s = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
        Follow up:
        If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start=0,end=0;
        int d=Integer.MAX_VALUE;
        int counter = s;
        while(end<nums.length){
            counter-=nums[end];
            while(counter<=0){
                d=Math.min(d,end-start+1);
                counter+=nums[start];
                start++;
            }
            end++;
        }
        return d==Integer.MAX_VALUE?0:d;
    }
}

