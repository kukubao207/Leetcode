import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args){
        int []nums = {1, 5, 1, 1, 6, 4,3};
        wiggleSort(nums);
    }
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        //对于偶数个的数组, 0 2 3 4      4/2 - 1 = 1;    前半段比后半段长1           奇数偶数相同
        //对于奇数个的数组, 0 3 4 5 8    5/2 - 1 = 1;    前后一样长                 奇数多
        int left_index = nums.length%2==0? nums.length/2-1:nums.length/2;
        int right_index = nums.length-1;
        int[] sorted = nums.clone();
        //将前半段倒序填入偶数位，后半段倒序填入奇数位
        for(int i=0;i<nums.length;i++){
            sorted[i] = i%2 ==0? nums[left_index--]:nums[right_index--];
        }
    }
}
