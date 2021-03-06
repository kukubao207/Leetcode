package TwoPointer.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//167. Two Sum II - Input array is sorted
//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
//        函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
//        说明:
//
//        返回的下标值（index1 和 index2）不是从零开始的。
//        你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//        示例:
//
//        输入: numbers = [2, 7, 11, 15], target = 9
//        输出: [1,2]
//        解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
public class TwoSum_II {
    public static void main(String[] args){
        int numbers[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum_one(numbers, target)));
    }
    //存入hash
    //时间复杂度O(n)
    //空间复杂度O(n)
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            int another = target - numbers[i];
            if (map.containsKey(another)){
                return new int[]{map.get(another) + 1, i + 1};
            }
            map.put(numbers[i],i);
        }
        throw new IllegalArgumentException("No result");
    }
    //排序数组
    //时间复杂度O(n)
    //空间复杂度O(1)
    public static int[] twoSum_one(int[] numbers, int target) {
        int i = 0;//i存放最小值的索引
        int j = numbers.length - 1; //j存放最大值的索引
        while(i < j){
            if(numbers[i] + numbers[j] < target)
                i++;
            else if(numbers[i] + numbers[j] > target)
                j--;
            else
                break;
        }
        return new int[]{i + 1, j + 1};
    }
}
