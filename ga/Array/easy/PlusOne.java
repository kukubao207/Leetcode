package Array.easy;

import java.util.Arrays;

//66. Plus One
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//        最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
//
//        你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//        示例 1:
//
//        输入: [1,2,3]
//        输出: [1,2,4]
//        解释: 输入数组表示数字 123。
//        示例 2:
//
//        输入: [4,3,2,1]
//        输出: [4,3,2,2]
//        解释: 输入数组表示数字 4321。
public class PlusOne {
    public static void main(String args[]) {
        int[] digits = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));

    }

    //时间复杂度O(n)
    //空间复杂度O(n)
    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] = digits[i] + 1;
        while (i >= 0 && digits[i] == 10) {
            digits[i] = 0;
            i--;
            if (i != -1) {
                digits[i] = digits[i] + 1;
            }
        }
        if (i == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
