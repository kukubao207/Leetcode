package Math.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 166.给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

 如果小数部分为循环小数，则将循环的部分括在括号内。

 示例 1:

 输入: numerator = 1, denominator = 2
 输出: "0.5"
 示例 2:

 输入: numerator = 2, denominator = 1
 输出: "2"
 示例 3:

 输入: numerator = 2, denominator = 3
 输出: "0.(6)"

 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder("");
        //1.符号部分
        if (numerator < 0 && denominator > 0 || (numerator > 0 && denominator < 0))
            sb.append("-");
        //2.整数部分
        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);
        sb.append(a / b);

        a = a % b;
        if (a == 0)
            return sb.toString();
        //3.小数部分
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(a, sb.length());
        while (a != 0) {
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (!map.containsKey(a)) {
                map.put(a, sb.length());
            } else {
                sb.insert(map.get(a), "(").append(")");
                break;
            }
        }
        return sb.toString();

    }
}
