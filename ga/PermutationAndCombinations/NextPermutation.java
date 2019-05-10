package PermutationAndCombinations;

import java.util.Arrays;

//31. Next PermutationAndCombinations
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//必须原地修改，只允许使用额外常数空间。
//
//以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class NextPermutation {
    public static void main(String args[]){
        int[] nums = new int[]{1,1,5};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }
/*
1.判断按照字典序有木有下一个，如果完全降序就没有下一个
2.如何判断有木有下一个呢？只要存在a[i-1] < a[i]的升序结构，就有，而且我们应该从右往左找，一旦找到，因为这样才是真正下一个
3.当发现a[i-1] < a[i]的结构时，从在[i, ∞]中找到最接近a[i-1]并且又大于a[i-1]的数字，由于降序，从右往左遍历即可得到k
4.然后交换a[i-1]与a[k]，然后对[i, ∞]排序即可，排序只需要首尾不停交换即可，因为已经是降序 上面说的很抽象，还是需要拿一些例子思考才行，比如[0,5,4,3,2,1]，下一个是[1,0,2,3,4,5]*/
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int[] nextPermutation(int[] nums) {
        if(nums.length < 1)
            return null;
        int j =  nums.length - 1;
        while(j >= 1 && nums[j - 1] >= nums[j])
            j--;
        if(j == 0){
            Arrays.sort(nums);
            return nums;
        }
        int i = nums.length - 1;
        while(nums[i] <= nums[j - 1]){
            i--;
        }
        swap(nums, i, j - 1);
        int t = nums.length - 1;
        while(t > j){
            swap(nums, t, j);
            t--;
            j++;
        }
        return nums;
    }
}
