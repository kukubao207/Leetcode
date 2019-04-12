package tx;

import java.util.*;

public class tx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String res = decodeString(str);
        System.out.println(new StringBuilder(res).reverse().toString());
    }

    public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int idx = 0;
        result.push("");
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (ch >= '0' && ch <= '9') {
                int start = idx;
                while (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '9')
                    idx++;
                count.push(Integer.parseInt(s.substring(start, idx + 1)));
            } else if (ch == '[' || ch == '{' || ch == '(') {
                result.push("");
            } else if (ch == ']' || ch == '}' || ch == ')') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            idx += 1;
        }
        return result.pop();
    }

}
