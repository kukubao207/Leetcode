package Exam.exam20190802;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给出两个在m进制下含有n位的数字，你可以分别将这两个数各位上的数字重新排列，然后将这两个数对应相加并分别对m取模，这样显然可以得到一个新的m进制下的n位数（可能存在前导0）
 * 但是这个结果是不唯一的，问题来了， 这样的操作，能够得到的最大的m进制下的数字是多少?
 */
public class exam1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //数字含有n位  在m进制下
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num1 = new int[n];
        int[] num2 = new int[n];
        for(int i = 0; i < n; i++){
            num1[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            num2[i] = sc.nextInt();
        }
        List<Integer> tmp1 = new ArrayList<>();
        List<List<Integer>> res1 = new ArrayList<>();
        int[] used1 = new int[n];
        dfs(num1, tmp1, res1, used1);
//        System.out.println(res1);

        List<Integer> tmp2 = new ArrayList<>();
        List<List<Integer>> res2 = new ArrayList<>();
        int[] used2 = new int[n];
        dfs(num2, tmp2, res2, used2);
//        System.out.println(res2);

        List<List<Integer>> res = new ArrayList<>();
        for(List list1: res1){
            for(List list2: res2){
                res.add(new ArrayList<>(addList(list1, list2, m)));
            }
        }
//        System.out.println(res);

//        for(List list: res){
//            for(int i = 0; i < list.size(); i++){
//                list.set(i, (int)list.get(i) % m);
//            }
//        }
//        System.out.print(res);

        List<Integer> result = res.get(0);
        for(List list: res){
            result = getMax(result, list);
        }
        System.out.print(result.toString());
    }


    public static void dfs(int[] num, List<Integer> tmp, List<List<Integer>> res, int[] used){
        int n = num.length;
        if(tmp.size() == n){
            res.add(new ArrayList<>(tmp));
        }
        if(tmp.size() > n)
            return;
        int lastUsed = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(num[i] != lastUsed && used[i] == 0){
                tmp.add(num[i]);
                used[i] = 1;
                dfs(num, tmp, res, used);
                used[i] = 0;
                lastUsed = tmp.get(tmp.size() - 1);
//                used[tmp.size() - 1] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static List<Integer> getMax(List<Integer> list1, List<Integer> list2){
        if(list1.equals(null))
            return list2;
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) > list2.get(i))
                return list1;
            else if(list2.get(i) > list1.get(i))
                return list2;
        }
        return list1;
    }

    public static List<Integer> addList(List<Integer> list1, List<Integer> list2, int m){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < list1.size(); i++)
            list.add((list1.get(i) + list2.get(i)) % m);
        return list;
    }

}
