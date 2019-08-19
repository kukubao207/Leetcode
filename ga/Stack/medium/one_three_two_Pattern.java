package Stack.medium;

import java.util.*;

//456. 132 Pattern
//Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
//
//Note: n will be less than 15,000.
//
//Example 1:
//Input: [1, 2, 3, 4]
//
//Output: False
//
//Explanation: There is no 132 pattern in the sequence.
//Example 2:
//Input: [3, 1, 4, 2]
//
//Output: True
//
//Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
//Example 3:
//Input: [-1, 3, 2, 0]
//
//Output: True
//
//Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
public class one_three_two_Pattern {
    public static void main(String[] args){
        test();
    }
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        int second = Integer.MIN_VALUE; // 132中的2
        Stack<Integer> stack = new Stack<>();// 用来存储132中的3
        if(nums.length < 3)
            return false;
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] < second) // 若出现132中的1则返回正确值
                return true;
            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素）
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                second = stack.pop();//second找最大值
            }
            // 将当前值压入栈中
            stack.push(nums[i]);
        }
        return false;
    }

    public static void test(){
        int[] nums = new int[]{1, 4, 2};
        find132pattern(nums);
    }
}
