package Math.medium;
//8. String to Integer (atoi)
//Implement atoi which converts a string to an integer.
//
//The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//If no valid conversion could be performed, a zero value is returned.
//
//Note:
//
//Only the space character ' ' is considered as whitespace character.
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//Example 1:
//
//Input: "42"
//Output: 42
//Example 2:
//
//Input: "   -42"
//Output: -42
//Explanation: The first non-whitespace character is '-', which is the minus sign.
//             Then take as many numerical digits as possible, which gets 42.
//Example 3:
//
//Input: "4193 with words"
//Output: 4193
//Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//Example 4:
//
//Input: "words and 987"
//Output: 0
//Explanation: The first non-whitespace character is 'w', which is not a numerical
//             digit or a +/- sign. Therefore no valid conversion could be performed.
//Example 5:
//
//Input: "-91283472332"
//Output: -2147483648
//Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//             Thefore INT_MIN (−231) is returned.
public class StringtoInteger {
    //+ 0 123 //输出0 因为+后面是空格
    //当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号(**连续)
    public int myAtoi(String str) {
        long res = 0;
        if(str.equals(null) || str.length() == 0)
            return 0;
        str = str.trim();
        if(str.equals(""))
            return 0;
        int i = 0;
        int sign = 1;//是否为负数
        if(str.charAt(i) == '-'){
            i++;
            sign = -1;
        }else if(str.charAt(i) == '+')
            i++;
        while(i < str.length() && Character.isDigit(str.charAt(i))){
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) res * sign;
    }

    public static int myAtoi1(String s) {
        int result = 0;
        boolean negative = false;
        int digit;
        s = s.trim();
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return 0;
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                digit = Character.digit(s.charAt(i++), 10);
                if(result < limit / 10)
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                result *= 10;
                if(result - digit < limit)
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                result -= digit;
            }
        }
        return negative ? result : -result;
    }
    public static void main(String[] args){
//        System.out.print(Integer.parseInt("15a", 10));
//        Integer.parseInt("1");
        test();
    }
    public static void test(){
        String s = "-91283472332";
        System.out.println(myAtoi1(s));
        String s1 = "words and 987";
        String s2 = "   -42";
        String s3 = "42";
        String s4 = String.valueOf(Integer.MIN_VALUE);
        String s5 = String.valueOf(Integer.MAX_VALUE);
        System.out.println(myAtoi1(s1));
        System.out.println(myAtoi1(s2));
        System.out.println(myAtoi1(s3));
        System.out.println(myAtoi1(s4));
        System.out.println(myAtoi1(s5));
    }
}
