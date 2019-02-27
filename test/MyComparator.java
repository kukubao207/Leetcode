import java.util.Arrays;
import java.util.Comparator;

public class MyComparator {
    public static void main(String[] args){
        int[] nums = {3,30,34,5,9};
        Solution.largestNumber(nums);
    }
    public static class Solution {
        public static class myComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer num1,Integer num2){
                String n1 = String.valueOf(num1)+String.valueOf(num2);
                String n2 = String.valueOf(num2)+String.valueOf(num1);
                return n2.compareTo(n1);
            }
        }
        public static String largestNumber(int[] nums) {
            Integer[] numArray = new Integer[nums.length];
            for(int i=0;i<nums.length;i++)
                numArray[i]=nums[i];
            Arrays.sort(numArray,new myComparator());
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<nums.length;i++){
                sb.append(nums[i]);
            }
            return sb.toString();
        }


    }
}
