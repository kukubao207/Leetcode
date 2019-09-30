package String.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 17.给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        String digits = "23";
        System.out.print(letterCombinations(digits));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        return helper(digits);
    }


    public static List<String> helper(String digits){
        List<String> res = new ArrayList<>();
        if(digits == null){
            return res;
        }if(digits.length() == 0){
            res.add("");
            return res;
        }
        List<String> tmp = helper(digits.substring(1, digits.length()));
        if(digits.charAt(0) == '2'){
            for(String str : tmp){
                res.add("a" + str);
                res.add("b" + str);
                res.add("c" + str);
            }
        }if(digits.charAt(0) == '3'){
            for(String str : tmp){
                res.add("d" + str);
                res.add("e" + str);
                res.add("f" + str);
            }
        }if(digits.charAt(0) == '4'){
            for(String str : tmp){
                res.add("g" + str);
                res.add("h" + str);
                res.add("i" + str);
            }
        }if(digits.charAt(0) == '5'){
            for(String str : tmp){
                res.add("j" + str);
                res.add("k" + str);
                res.add("l" + str);
            }
        }if(digits.charAt(0) == '6'){
            for(String str : tmp){
                res.add("m" + str);
                res.add("n" + str);
                res.add("o" + str);
            }
        }if(digits.charAt(0) == '7'){
            for(String str : tmp){
                res.add("p" + str);
                res.add("q" + str);
                res.add("r" + str);
                res.add("s" + str);
            }
        }if(digits.charAt(0) == '8'){
            for(String str : tmp){
                res.add("t" + str);
                res.add("u" + str);
                res.add("v" + str);
            }
        }if(digits.charAt(0) == '9'){
            for(String str : tmp){
                res.add("w" + str);
                res.add("x" + str);
                res.add("y" + str);
                res.add("z" + str);
            }
        }
        return res;
    }
}
