package DP.easy;
//53 Maximum Subarray
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//        示例:
//
//        输入: [-2,1,-3,4,-1,2,1,-5,4],
//        输出: 6
//        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//        进阶:
//
//        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
public class MaximumSubarray {
    public static void main(String args[]){
        int[] nums = new int[]{-2,3,0,2,-2,3};
        System.out.println(maxSubArray_one(nums));
    }

    //暴力
    //时间复杂度O(n*n)（不满足题目要求）
    public static int maxSubArray_one(int[] nums) {
        int res = nums[0];
        for(int i = 0; i< nums.length; i++){
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                sum = sum + nums[j];
                if(sum > res){
                    res = sum;
               }
            }
        }
        return res;
    }

    public static int max(int a, int b){
        if(a >= b){
            return a;
        }else{
            return b;
        }
    }
    //定义一个函数f(n)，以第n个数为结束点的子数列的最大和，存在一个递推关系f(n) = max(f(n-1) + nums[n], nums[n]);
    public static int f_n(int n, int[] nums){
        if(n == 0){
            return nums[0];
        }else{
            return max(f_n(n-1, nums) + nums[n], nums[n]);
        }
    }
    //动态规划法
    //时间复杂度O(n),空间复杂度O(n)
    public static int maxSubArray_two(int[] nums) {
        if(nums.length == 0)
            return -1;
        int res = nums[0];
        for(int i = 0; i< nums.length; i++){
           int sum = f_n(i,nums);
           if(sum > res)
               res = sum;
        }
        return res;
    }



    //分治算法
    public static int maxSubArray_three(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return y_n(start, end, nums);
    }
    public static int getmax(int a, int b, int c){
        if(a >= b && a >= c)
            return a;
        else if(b >= a && b >= c)
            return b;
        else
            return c;
    }
    //比较左、右、中间三部分的序列和的大小
    //时间复杂度O(n),空间复杂度O(n)
    public static int y_n(int start, int end, int[] nums){
        if(start == end)
            return nums[start];
        int middle = (start + end) / 2;
        int maxLeftSum = y_n(start, middle, nums);
        int maxRightSum = y_n(middle + 1,end, nums);
        //计算左边界最大子序列和（无法分治）
        int leftBonderSum = nums[middle];
        int leftsum = nums[middle];
        for(int i = middle - 1; i >= 0; i--){
            leftsum = leftsum + nums[i];
            if(leftsum > leftBonderSum){
                leftBonderSum = leftsum;
            }
        }
        //计算右边界最大子序列和（无法分治）
        int rightBonderSum = nums[middle];
        int rightsum = nums[middle];
        for(int i = middle + 1; i < nums.length; i++){
            rightsum = rightsum + nums[i];
            if(rightsum > rightBonderSum){
                rightBonderSum = rightsum;
            }
        }
        return getmax(maxLeftSum, maxRightSum, leftBonderSum +  rightBonderSum - nums[middle]);
    }

}
