package Offer;

/**把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 输入描述:
 输入一个字符串,包括数字字母符号,可以为空
 输出描述:
 如果是合法的数值表达则返回该数字，否则返回0
 */
public class StringParseInt {
    public int StrToInt(String str) {
        int res = 0;
        if(str == null || str.length() == 0)
            return 0;
        boolean isNegative = false;
        for(int i = 0; i < str.length(); i++){
            if(i == 0 && str.charAt(i) == '+')
                isNegative = false;
            else if(i == 0 && str.charAt(i) == '-')
                isNegative = true;
            else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if (isNegative == false && res * 10 > Integer.MAX_VALUE - (str.charAt(i) - '0'))
                    return 0;
                if (isNegative == true && res * 10 - 1 > Integer.MAX_VALUE - (str.charAt(i) - '0'))
                    return 0;
                res = res * 10 + str.charAt(i) - '0';
            }else
                return 0;
        }
        return isNegative == true ? -1 * res : res;
    }
}
