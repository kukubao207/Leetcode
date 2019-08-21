package Exam.bilibili;

import java.util.HashMap;
import java.util.Map;

/**
 * 子串是连续的  子序列才无需连续，保持相对位置即可
 * 给定字符A和字符集B，求在A中包含了B所有字符的最小子串（最小子串是连续的）
 * 输出包含字符集所有字符的第一个最小子串
 *如果没有符合条件的子串，则输出#
 */
public class exam3 {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        String str = "ABAKJSDYUIWNQJNDSAHDBALSDH";
        String charSet = "ABD";
        System.out.println(findZichuan1(str, charSet));
    }
//    public static String outPut(String str, String charSet){
//        int n = str.length();
//        int m = charSet.length();
//        if(str.equals(null))
//            return "#";
//        if(m == 1){
//            if(str.contains(charSet))
//                return charSet;
//            else return "#";
//        }
//        int index = 0;
//        for(int i = 0; i < str.length(); i++){
//            if(str.charAt(i) == charSet.charAt(index)){
//                String s1 = str.charAt(i) + outPut(str.substring(i + 1,n), charSet.substring(index + 1, m));
//                String s2 = outPut(str.substring(i + 1, n), charSet);
//                if(s1.length() > s2.length())
//                    return s1;
//                else return s2;
//            }
//        }
//        return "#";
//    }

    public static String findZichuan1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();//map记录t中的各元素未出现在字符串s中次数 //map认为其get方法的时间复杂度为O(1)
        for(Character c: t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);//防止t中有重复的元素
        int start = 0, end = 0;
        int count = t.length();//记录有多少元素未在s字符串中出现
        int head = 0;
        int d = Integer.MAX_VALUE;//记录子串的长度
        while(end < s.length()){
            Character end_c = s.charAt(end);
            if(map.getOrDefault(end_c, 0) > 0)
                count--;
            map.put(end_c, map.getOrDefault(end_c, 0) - 1);
            end++;
            while(count == 0){
                Character start_c = s.charAt(start);
                if(end - start < d){
                    head = start;
                    d = end - start;
                }
                if(map.getOrDefault(start_c, 0) == 0)
                    count++;
                map.put(start_c, map.getOrDefault(start_c, 0) + 1);
                start++;
            }
        }
        return d == Integer.MAX_VALUE ? "#" : s.substring(head, head + d);
    }





    public static String findZichuan(String s, String t) {
        // 首先用HashMap保存t中每一个字符出现的次数
        Map<Character, Integer> m = new HashMap<>();
        for (Character c : t.toCharArray())
            m.put(c, m.getOrDefault(c, 0) + 1);
        // 维护begin和end指针
        int begin = 0, end = 0, head = 0;
        int d = Integer.MAX_VALUE;
        int counter = t.length();       // 当count为0的时候，说明t中的元素被[begin,end]全都包含了
        while (end < s.length()) {
            Character end_c = s.charAt(end);
            if (m.getOrDefault(end_c, 0) > 0)
                counter--;
            m.put(end_c, m.getOrDefault(end_c, 0) - 1);
            end++;
            while (counter == 0) {
                Character begin_c = s.charAt(begin);
                if (end - begin < d) {
                    d = end - (head = begin);
                }
                if (m.getOrDefault(begin_c, 0) == 0) {
                    counter++;
                }
                m.put(begin_c, m.getOrDefault(begin_c, 0) + 1);
                begin++;
            }
        }
        return d == Integer.MAX_VALUE ? "#" : s.substring(head, head + d);
    }
}
