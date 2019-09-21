package Offer;

import java.util.Arrays;
import java.util.Comparator;

/**把数组拍成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ArrangeArr {
    public String PrintMinNumber(int [] numbers) {
        Integer[] nums = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            nums[i] = numbers[i];
        Arrays.sort(nums, new SortByStr());
        String res = "";
        for(int i = 0 ; i < numbers.length; i++)
            res += nums[i];
        return res;
    }
    public class SortByStr implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2){
            String str1 = String.valueOf(i1) + String.valueOf(i2);
            String str2 = String.valueOf(i2) + String.valueOf(i1);

            if(str1.compareTo(str2) > 0)
                return 1;
            else if(str1.compareTo(str2) < 0)
                return -1;
            else return 0;
        }
    }
}
