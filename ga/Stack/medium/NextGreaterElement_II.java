package Stack.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//503. Next Greater Element II
//Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
//
//Example 1:
//Input: [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2;
//The number 2 can't find next greater number;
//The second 1's next greater number needs to search circularly, which is also 2.
public class NextGreaterElement_II {
    //1.暴力
    public int[] nextGreaterElements(int[] nums) {
        int[] nextBigger = new int[nums.length];
        boolean flag = true;
        Arrays.fill(nextBigger, -1);
        for(int i = 0; i < nums.length; i++){
            flag = true;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    nextBigger[i] = nums[j];
                    flag = false;
                    break;
                }
            }
            if(flag)
                for(int k = 0; k < i; k++){
                    if(nums[k] > nums[i]){
                        nextBigger[i] = nums[k];
                        break;
                    }
                }
        }
        return nextBigger;
    }
    //2.利用栈
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        Arrays.fill(res, -1);
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++){
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()])//有点动态规划的思想
                res[stack.pop()] = num;
            if(i < n) stack.push(i);
        }
        return res;
    }
}
