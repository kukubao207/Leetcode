442. Find All Duplicates in an Array

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

思路
把（当前访问的元素-1）看做是当前数组中的下标，把那个位置设置为负数，但保留原来的值。
如果某次访问时，遇到下标对应的数字为负数，说明这个元素在之前出现过，直接加入结果集中。

代码
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
                res.add(Math.abs(nums[i]));
            nums[index]=-nums[index];
        }
        return res;
    }
}