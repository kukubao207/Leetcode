import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        nextPermutation(nums);
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1;
        for (; j > i; j--) {
            if (nums[j] > nums[i])
                break;
        }
        swap(nums, i, j);
        Arrays.sort(nums, i + 1, nums.length);
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
