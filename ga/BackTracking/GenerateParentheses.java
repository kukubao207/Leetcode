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

    //dfs + 剪枝
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }

    //left统计“(”的个数，right统计“)”的个数
    public static void dfs(List<String> res, String tmp, int left, int right) {
        if(left == 0 && right == 0) {
            res.add(tmp);
            return;
        }
        if(left > 0) {
            dfs(res, tmp + "(", left - 1, right);
        }
        //只有在当前序列中的左括号数大于右括号数的时候加上右括号才能形成有效序列
        if(right > left) {
            dfs(res, tmp + ")", left, right - 1);
        }
    }
}
