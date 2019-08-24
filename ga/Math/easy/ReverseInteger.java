package Math.easy;
//7. Reverse Integer
//Given a 32-bit signed integer, reverse digits of an integer.
//
//Example 1:
//
//Input: 123
//Output: 321
//Example 2:
//
//Input: -123
//Output: -321
//Example 3:
//
//Input: 120
//Output: 21
//Note:
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = false;//是否为负数
        int result = 0;
        if(x < 0){
            flag = true;
            x = -x;
        }
        String res = "";
        while(x > 0){
            int n = x % 10;
            if(!(res.equals("") && n == 0))
                res += n;
            x = x / 10;
        }
        try {
            result = Integer.parseInt(res);
            if(flag)
                result = 0 - result;
        }catch (Exception e){
            result = 0;
        }
       return result;
    }

    public int reverse1(int x) {
        long res = 0;
        while(x != 0){
            res *= 10;
            res += x % 10;
            x = x / 10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int)res;
    }

    public int reverse2(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
