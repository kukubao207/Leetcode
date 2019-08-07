package Exam.pdd;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个字符串数组，所有字符均为大写字母，请问给定的字符串数组是否能够通过更换数组中元素的顺序，
 从而首尾相连，形成一个环，环上相邻字符串首尾衔接的字符相同
 */
    // 测试用例：
    //CAT TIGER RPC
    //CAT RPC TIGER
    //TIGER CAT RPC
    //CAT RPC
    //TIGER RPC

// 这个题看下我怎么写的，慢慢来ba.
public class exam2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] str = s.split(" ");
//        System.out.print(judge(str));
        test();
    }

    public static boolean judge(String[] str){
        List<String> tmp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        boolean isTrue = false;
        dfs(str, tmp, res);
        for(List list: res){
            String[] strings = new String[list.size()];
            list.toArray(strings);
            isTrue = isTrue || isCircle(strings);
        }
        return isTrue;
    }
    public static boolean isCircle(String[] str){
        boolean res = true;
        int pre_start = str[str.length - 1].charAt(0);
        int pre_end = str[str.length - 1].charAt(str[str.length - 1].length() - 1);
        for(int i = 0; i < str.length; i++){
            int start = str[i].charAt(0);
            int end = str[i].charAt(str[i].length() - 1);
            int next = i + 1;
            if(next >= str.length)
                next = 0;
            if(start == pre_end && end == str[next].charAt(0)){
                pre_start = start;
                pre_end = end;
                continue;
            }
            else{
                res = false;
                break;
            }
        }
        return res;
    }

    public static void dfs(String[] str, List<String> tmp, List<List<String>> res) {
        if(tmp.size() ==  str.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        String lastUsed = "";
        for(int i = 0; i < str.length; i++){
            if(!tmp.contains(str[i]) && str[i] != lastUsed){
                tmp.add(str[i]);
                dfs(str, tmp, res);
                lastUsed = tmp.get(tmp.size() - 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void test(){
        String[] case1 = {"CAT","TIGER", "RPC"};
        String[] case2 = {"CAT", "RPC", "TIGER"};
        String[] case3 = {"TIGER", "CAT", "RPC"};
        String[] case4 = {"CAT", "RPC"};
        String[] case5 = {"TIGER", "RPC"};
        String[] case6 = {"OK"};
        String[] case7 = {"OO"};
        System.out.println(judge(case1));
        System.out.println(judge(case2));
        System.out.println(judge(case3));
        System.out.println(judge(case4));
        System.out.println(judge(case5));
        System.out.println(judge(case6));
        System.out.println(isCircle(case7));
    }
}
