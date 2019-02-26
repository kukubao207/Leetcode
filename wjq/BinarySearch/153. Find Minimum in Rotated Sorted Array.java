153. Find Minimum in Rotated Sorted Array

        Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

        Find the minimum element.

        You may assume no duplicate exists in the array.

        Example 1:

        Input: [3,4,5,1,2]
        Output: 1
        Example 2:

        Input: [4,5,6,7,0,1,2]
        Output: 0

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
            }else{
                l=m;
            }
        }
        if(nums[l]<nums[r])
            return nums[l];
        else
            return nums[r];
    }
}

改进下代码
class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r-1)
        {
            int m = l + (r-l)/2;
            if(nums[m]<nums[r]){
                r=m;
            }else{
                l=m;
            }
        }
        if(nums[l]<nums[r])
            return nums[l];
        else
            return nums[r];
    }
}