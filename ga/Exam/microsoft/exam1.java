package Exam.microsoft;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */


// 给一组String，找出有多少个不同的String。
// 不同的定义是：（交换不可以得到，交换的前提是(i + j) % 2 == 0）。
public class exam1 {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        int N = 3;
        String[] passwords = new String[]{"abcdefg", "cfabgde", "adgbcfe"};
        System.out.print(getDistinctPass(N, passwords));
    }
    public static int getDistinctPass (int N, String[] passwords){
        int count = 0;
        Arrays.sort(passwords, new SoretedByLength());

        int i = 0;
       while(i < passwords.length){
            if(i + 1 < passwords.length && passwords[i].length() == passwords[i + 1].length()){
                String[] pass = new String[N];
                int j = 0;
                while(i + 1 < passwords.length  && passwords[i].length() == passwords[i + 1].length()){
                    String str = helper(passwords[i]);
                    pass[j++] = str;
                    i++;
                }
                String str = helper(passwords[i]);
                pass[j++] = str;
                i++;
                count += GetNum(pass);
            }
           else{
                count++;
                i++;
           }
        }
        return count;
    }

    static class SoretedByLength implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length())
                return -1;
            else if(o1.length() < o2.length())
                return 1;
            return 0;
        }
    }

    public static String helper(String str){
        int n = str.length();
        char[] even = new char[n];
        char[] odd = new char[n];
        int p = 0;
        int q = 0;
        for(int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[p++] = str.charAt(i);
            } else {
                odd[q++] = str.charAt(i);
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        return String.valueOf(even) + String.valueOf(odd);
    }
    public static int GetNum(String[] strs){
        Arrays.sort(strs);
        int i = 0;
        int count = 0;
        while(i < strs.length){
            if(i + 1 < strs.length && strs[i].compareTo(strs[i + 1]) == 0){
                while(i + 1 < strs.length  && strs[i].compareTo(strs[i + 1]) == 0){
                    i++;
                }
                count++;
                i++;
            }else{
                count++;
                i++;
            }
        }
        return count;
    }
}
