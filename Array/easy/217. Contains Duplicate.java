217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

我的解法
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        for(int i=0;i<nums.length;i++){
            if(map.getOrDefault(nums[i],false)==true)
                return true;
            else
                map.put(nums[i],true);
        }
        return false;
    }
}

别人的解法
class Solution {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> distinct = new HashSet<Integer>();
        for(int num : nums) {
            if(distinct.contains(num))
                return true;
            distinct.add(num);
        }
        return false;
    }
}