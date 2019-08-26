package Math.medium;
//43. Multiply Strings
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//Example 1:
//
//Input: num1 = "2", num2 = "3"
//Output: "6"
//Example 2:
//
//Input: num1 = "123", num2 = "456"
//Output: "56088"
//Note:
//
//The length of both num1 and num2 is < 110.
//Both num1 and num2 contain only digits 0-9.
//Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//You must not use any built-in BigInteger library or convert the inputs to integer directly.
public class MultiplyStrings {
    /**
     num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
     例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
     index:    0 1 2 3 4

     1 2 3
     *     4 5
     ---------
     1 5
     1 0
     0 5
     ---------
     0 6 1 5
     1 2
     0 8
     0 4
     ---------
     0 5 5 3 5
     这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中
     **/
    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if(n1 < 0 || n2 < 0) return "";
        int[] mul = new int[n1 + n2 + 2];
        for(int i = n1; i >= 0; i--) {
            for(int j = n2; j >= 0; j--) {
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                bitmul += mul[i + j + 1]; // 先加低位判断是否有新的进位
                mul[i + j] += bitmul / 10;
                mul[i + j + 1] = bitmul % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while(i < mul.length - 1 && mul[i] == 0)
            i++;
        for(; i < mul.length; i++)
            sb.append(mul[i]);
        return sb.toString();
    }

}
