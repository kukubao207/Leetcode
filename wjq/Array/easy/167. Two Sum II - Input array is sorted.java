167. Two Sum II - Input array is sorted

        Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

        The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

        Note:

        Your returned answers (both index1 and index2) are not zero-based.
        You may assume that each input would have exactly one solution and you may not use the same element twice.
        Example:

        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

题意
在一个排序的数组中，找出两个数的和为target

思路
双指针法
一个指针指向0，一个指针指向numbers.length-1
因为数组排过序，所以移动左指针一定能使得和变大，移动右指针一定能使得和变小，
和最终会收缩到target

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] ans = new int[2];
        while(left<right){
            if(target == numbers[left] + numbers[right]){
                ans[0]=left+1;
                ans[1]=right+1;
                return ans;
            }else if(target < numbers[left] + numbers[right]){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}
