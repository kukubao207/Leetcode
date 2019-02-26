154. Find Minimum in Rotated Sorted Array II

        Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

        Find the minimum element.

        The array may contain duplicates.

        Example 1:

        Input: [1,3,5]
        Output: 1
        Example 2:

        Input: [2,2,2,0,1]
        Output: 0
        Note:

        This is a follow up problem to Find Minimum in Rotated Sorted Array.
        Would allow duplicates affect the run-time complexity? How and why?

我的思路
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int ans = 0;
        int l=0,r=nums.length-1;
        while(l<r-1)
        {
            int m = l + (r-l)/2;
            if(m==0&&nums[m]<nums[m+1]
                    || (m==nums.length-1&&nums[m-1]>nums[m])
                    || (nums[m-1]>nums[m]&&nums[m]<nums[m+1]))
                return nums[m];
            if(nums[m]<nums[r]){
                r=m;
            }else if(nums[m]>nums[r]){
                l=m;
            }else{
                r--;
            }
        }
        if(nums[l]<nums[r])
            return nums[l];
        else
            return nums[r];
    }
}

简化下代码
class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r-1)
        {
            int m = l + (r-l)/2;
            if(nums[m]<nums[r]){
                r=m;
            }else if(nums[m]>nums[r]){
                l=m;
            }else{
                r--;
            }
        }
        if(nums[l]<nums[r])
            return nums[l];
        else
            return nums[r];
    }
}