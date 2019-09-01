package Math.easy;
//67. Add Binary
//Given two binary strings, return their sum (also a binary string).
//
//The input strings are both non-empty and contains only characters 1 or 0.
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while(i >= 0 || j >= 0 ){
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            //重新计算进位
            carry = sum / 2;
            builder.append(sum % 2);
            i--;
            j--;
        }
        //循环结算，考虑还有最后一次进位的情况
        if(carry > 0){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
