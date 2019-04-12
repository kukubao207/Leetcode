package Array.easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。*/
public class TwoSum {
    public static void main(String[] args){
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum_one(nums, target)));
        System.out.println(Arrays.toString(twoSum_two(nums, target)));
        System.out.println(Arrays.toString(towSum_three(nums, target)));
    }
    //一次遍历，在进行迭代并将元素插入到表中的同时，回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
    //时间复杂度O(n),空间复杂度O(n)
    public static int[] twoSum_one(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int another = target - nums[i];
            if (map.containsKey(another)){
                return new int[]{map.get(another), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No result");
    }
    //两次遍历,在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，我们将检查每个元素所对应的目标元素(another)是否存在于表中。注意，该目标元素不能是 nums[i]nums[i] 本身！
    //时间复杂度O(n)，空间复杂度O(n)
    public static int[] twoSum_two(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            int another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i){
                return new int[]{i, map.get(another)};
            }
        }
        throw new IllegalArgumentException("No result");
    }
    //暴力法
    //时间复杂度O(n*n),空间复杂度O(1)
    public static int[] towSum_three(int[] nums, int target){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No result");
    }
}
