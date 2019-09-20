package Exam.xiaomi;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串，在字符串1中删除字符串2所包含的所有字符
 */
public class exam1 {
    public static void test(){
        String str1 = "Theyarestudents";
        String str2 = "aeiou";
        System.out.println(removeStr(str1, str2));
    }
    public static void main(String[] args){
        test();
    }
    public static String removeStr(String str1, String str2){
        String result = "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str2.length(); i++)
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) + 1);
        for(int i = 0; i < str1.length(); i++){
            if(map.containsKey(str1.charAt(i)))
                continue;
            else result += str1.charAt(i);
        }
        return result;
    }
}
