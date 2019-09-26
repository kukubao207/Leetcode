package BackTracking;

import java.util.*;

/**
 * 22给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */

public class GenerateParentheses {
    public static void main(String[] args){
        test();
    }

    public static void test(){
        int n = 3;
        System.out.print(generateParenthesis(n));
    }

    //https://leetcode-cn.com/problems/generate-parentheses/solution/java-shi-ji-xing-dai-ma-ac-ji-yu-hui-su-si-xiang-d/
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Set<String> set = helper(n);
        for(String s: set)
            res.add(s);
        return res;
    }

    public static Set<String> helper(int n) {
        Set<String> res = new HashSet<>();
        if(n == 0)
            return res;
        if(n == 1){
            res.add("()");
            return res;
        }
        else {
            Set<String> set = helper(n - 1);
            for (String s : set) {
                String s1 = s + "()";
                String s2 = "()" + s;
                String s3 = "(" + s + ")";
                res.add(s1);
                res.add(s2);
                res.add(s3);
            }
        }
        return  res;
    }
}
