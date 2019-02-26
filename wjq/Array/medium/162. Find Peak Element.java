162. Find Peak Element


        A peak element is an element that is greater than its neighbors.

        Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

        You may imagine that nums[-1] = nums[n] = -∞.

        Example 1:

        Input: nums = [1,2,3,1]
        Output: 2
        Explanation: 3 is a peak element and your function should return the index number 2.
        Example 2:

        Input: nums = [1,2,1,3,5,6,4]
        Output: 1 or 5
        Explanation: Your function can return either index number 1 where the peak element is 2,
        or index number 5 where the peak element is 6.



O(n)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        for(int i=0;i<nums.length;i++){
            if(i==0&&nums[i]>nums[i+1]||(i==nums.length-1&&nums[i]>nums[i-1]))
                return i;
            if(i!=0&&i!=nums.length-1&&nums[i]>nums[i-1]&&nums[i]>nums[i+1])
                return i;
        }
        return -1;
    }
}

O(logn)
class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r-1){
            int m1 = l + (r-l)/2;
            int m2 = m1+1;
            if(nums[m1]<nums[m2]){
                l=m2;
            }else{
                r=m1;
            }
        }
        return nums[l]>nums[r]?l:r;
    }
}