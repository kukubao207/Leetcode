package Greedy;

import java.util.Arrays;

//55. 跳跃游戏
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//判断你是否能够到达最后一个位置。
//
//示例 1:
//
//输入: [2,3,1,1,4]
//输出: true
//解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
//示例 2:
//
//输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
public class JumpGame {
    public static void main(String args[]){
        int[] nums = new int[]{2,0,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length == 1 && nums[0] == 0)
            return true;
        //1.如果所有元素都不为0， 那么一定可以跳到最后；
        //2.从后往前遍历，如果遇到nums[i] = 0，就找i前面的元素j，使得nums[j] > i - j。如果找不到，则不可能跳跃到num[i+1]，返回false。
        int i = nums.length - 1;;
        while(i >= 0) {
            if(nums[i] == 0){
                boolean flag = false;
                for(int j = i - 1; j >= 0; j--){
                    if(nums[j] > i - j || (nums[j] == i - j && i == nums.length - 1)){
                        i = j;
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    return false;
            }
            i--;
        }
        return true;
    }
    //从后往前遍历数组，如果遇到的元素可以到达最后一行，则截断后边的元素。否则继续往前，弱最后剩下的元素大于1个，则可以判断为假。否则就是真
    public static boolean canJump1(int[] nums) {
        int n = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= n){
                n = 1;
            }
            else{
                n++;
            }
            if(i == 0 && n > 1){
                return false;
            }
        }
        return true;
    }

    //采用贪心算法
    // 用一个 reach 变量 记录能够到达的最远的下标，每走一步比较更新该值，到达最终位置前，如果当前下标大于reach，说明失败。如果能到达最后，说明成功。
    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int reach = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > reach)
                return false;
            if(i + nums[i] > reach)
                reach = i + nums[i];
        }
        return true;
    }


}
