package Array.easy;

//198.You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

//Example 1:
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//Example 2:
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
public class HouseRobber {
    //典型的动态规划问题
    //定义一个与输入数组等长的dp数组，dp[i] 代表小偷从第1号到第号屋子偷钱的最大收益。
    //可简单推理出，如果偷了第i号屋子，收益为nums[i] + dp[i-2] (因为相邻不可偷)。如果不偷，收益为dp[i-1]. 逐步求最大值即可。
    public int rob(int[] nums) {
        int n = nums.length;
        if(n <= 1)
            return n == 0 ? 0 : nums[0];
        int[] dp = new int[n];//dp[i]表示[1...]的最大值
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
