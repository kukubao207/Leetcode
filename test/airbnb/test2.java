package airbnb;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(divide(2, 4));
        System.out.println(divide(6, 3));
        System.out.println(divide(1, 3));
        System.out.println(divide(229, 990));
    }

    public static String divide(int dividend, int divisor) {
        StringBuilder sb = new StringBuilder("");
        //1.符号部分
        if (dividend < 0 && divisor > 0 || (dividend > 0 && divisor < 0))
            sb.append("-");
        //2.整数部分
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
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
