package String;

import java.util.Arrays;

/**
 * split的用法
 * split处理了后面尾部的空字符串(删掉)，而不处理开头和中间的空字符串
 * split(regex)方法是根据匹配给定的正则表达式来拆分字符串的，regex取值特别注意.、|和*等转义字符的问题，遇到这些正则表达式转义字符务必添加\\或者[]转义。
 */
public class StringSplit {
    public static void main(String[] args){
        test();
    }

    public static void test(){
        String str1 = ",6,";
        String str2 = ",6";
        String str3 = "6,";
        String str4 = "";
        String str5 = ",,,,,";
        String str6 = "12345";
        String str7 = " .6";
        System.out.println(Arrays.toString(str1.split(",")));
        System.out.println(Arrays.toString(str2.split(",")));
        System.out.println(Arrays.toString(str3.split(",")));
        System.out.println(Arrays.toString(str4.split(",")));
        System.out.println(Arrays.toString(str5.split(",")));
        System.out.println(Arrays.toString(str6.split("\\.")));
        System.out.println(Arrays.toString(str7.split("[.]")));

    }
}
