package Array.easy;
//169. Majority Element
//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在众数。
//
//示例 1:
//
//输入: [3,2,3]
//输出: 3
//示例 2:
//
//输入: [2,2,1,1,1,2,2]
//输出: 2

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    //《剑指Offer》面试题39
    //这道题我面腾讯面试时候问了我，好好看看，《剑指offer》中两种时间O（n），空间O（1）的解法要掌握
    //讲摩尔投票讲的比较好的一篇
    //https://www.zhihu.com/question/49973163
    public static void main(String[] args){
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement_one(nums));
    }

    //摩尔投票算法
    //摩尔投票算法是基于这个事实：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个
    //时间复杂度O(n),空间复杂度O(1)
    public static int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(major == nums[i])
                count++;
            else{
                count--;
                if(count == 0)
                    major = nums[i + 1];
            }
        }
        return major;
    }

    //条件>n/2，所以排序后，中间元素一定是众数
    //时间复杂度 O（nlg(n)）,空间复杂度O(1)
    public static int majorityElement_one(int[] nums) {
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        return nums[nums.length / 2];
    }

    //全部遍历
    //时间复杂度O(n),空间复杂度O(n)
    public static int majorityElement_two(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        for(Integer key : map.keySet())
            if(map.get(key) > nums.length / 2)
                return key;
        return -1;
    }

    //找出大于1/3次的
    public static void vote(int[] a) {
        int major1 = 0, major2 = 1;
        int count1 = 0, count2 = 0;
        for (int cur : a) {
            if (cur == major1) {
                count1++;
            } else if (cur == major2) {
                count2++;
            } else {
                if (count1 == 0) {
                    major1 = cur;
                    count1 = 1;
                } else if (count2 == 0) {
                    major2 = cur;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for (int cur : a) {
            if (cur == major1)
                count1++;
            if (cur == major2)
                count2++;
        }
        if (count1 > a.length / 3)
            System.out.println(major1);
        if (count2 > a.length / 3)
            System.out.println(major2);
    }
}
