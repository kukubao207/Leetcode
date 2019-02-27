179. Largest Number

        Given a list of non negative integers, arrange them such that they form the largest number.

        Example 1:

        Input: [10,2]
        Output: "210"
        Example 2:

        Input: [3,30,34,5,9]
        Output: "9534330"
        Note: The result may be very large, so you need to return a string instead of an integer.

题意
给一个数组，用数组中的元素组合出一个最大值

我的思路
这题本质上是一道排序题，那么如何排序呢
如何判断 num1 是否应该在 num2 前？
考虑  3693  369  这两个元素，谁在前大，谁在后大？
把他们两个拼起来 再按字符串的字典序比较一下 就可以了
        3693369 < 3693693
        这说明  369 要排在 3693前面可以获得更大值


WA了一次，没考虑到全为0的特殊情况

class Solution {
    public class myComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer num1,Integer num2){
            String n1 = String.valueOf(num1)+String.valueOf(num2);
            String n2 = String.valueOf(num2)+String.valueOf(num1);
            return n2.compareTo(n1);
        }
    }
    public String largestNumber(int[] nums) {
        Integer[] numArray = new Integer[nums.length];
        boolean isZero = true;
        for(int i=0;i<nums.length;i++){
            numArray[i]=nums[i];
            if(nums[i]!=0)
                isZero=false;
        }
        if(isZero)
            return "0";
        Arrays.sort(numArray,new myComparator());
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<numArray.length;i++){
            sb.append(numArray[i]);
        }
        return sb.toString();
    }

}