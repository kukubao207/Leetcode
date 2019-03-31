43.Multiply Strings
        Given two non-negative integers num1 and num2 represented as strings,return the product of num1 and num2,also represented as a string.

        Example 1:

        Input:num1="2",num2="3"
        Output:"6"
        Example 2:

        Input:num1="123",num2="456"
        Output:"56088"
        Note:

        The length of both num1 and num2 is< 110.
        Both num1 and num2 contain only digits 0-9.
        Both num1 and num2 do not contain any leading zero,except the number 0itself.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.

        题意
        大数乘法
        给两个String的数，求它们相乘的结果，返回String

        思路
        竖式乘法
        1 2 3该String下标i[0,1,2]
        4 6该String下标j[0,1]

        1 8i=2,j=1结果[3,4]
        1 2i=1,j=1结果[2,3]
        0 6i=0,j=1结果[1,2]
        1 2i=2,j=0结果[2,3]
        0 8i=1,j=0结果[1,2]
        0 4i=0,j=0结果[0,1]
        pos 0 1 2 3 4下标[0,1,2,3,4]
        用int[]pos来保存中间结果，最后去掉前导0，返回一个String
        观察每两个数的下标和相乘后的结果的下标，
        发现i*j的结果一定对应pos数组中[i+j]和[i+j+1]的位置
        这个算法存在一个问题，有可能pos数组中最后存在前导0（仅限于第一位）
        也要注意边界值：num1为0或num2为0

        最终可以写出代码如下：

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i + j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            if (i == 0 && pos[i] == 0)
                continue;
            sb.append(pos[i]);
        }
        return sb.toString();
    }
}