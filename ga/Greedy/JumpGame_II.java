package Greedy;
//45. 跳跃游戏 II
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//示例:
//
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//说明:
//
//假设你总是可以到达数组的最后一个位置。
public class JumpGame_II {
    //需要添加 count 变量记录最少步数。
    // 什么时候 count++ 是问题的关键？答案是当前的位置 i 超过了上一跳所能到达的最远位置。所以需要引入变量 last 记录上一跳可达最远坐标。
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int reach = 0;//当前所能到达的最远坐标
        int last = 0;//上一跳可达最远坐标
        int count = 0;//跳跃次数
        for(int i = 0; i < nums.length; i++){
            if(i > reach)
                return -1;
            if(i > last){
                count++;
                last = reach;
            }
            if(i + nums[i] > reach)
                reach = i + nums[i];
        }
        return count;
    }

    //动态规划
    //时间复杂度O(n * n)
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];//dp[i] 为到达 i 位置的最小跳数
        dp[0] = 0;////到达下标0的最小跳数是0
        for(int i = 1; i < nums.length; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(i - j <= nums[j]){//可以一步从j到i
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

}
