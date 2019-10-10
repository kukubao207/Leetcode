260. Single Number III

        Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

        Example:

        Input:  [1,2,1,3,2,5]
        Output: [3,5]
        Note:

        The order of the result is not important. So in the above example, [5, 3] is also correct.
        Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

求数组中出现两次的数

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums)
            xor ^= n;
        xor &= (-xor);
        int[] res = new int[2];
        for (int n : nums) {
            if ((n & xor) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}