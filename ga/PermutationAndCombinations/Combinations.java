package PermutationAndCombinations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//77. Combinations
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//示例:
//
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class Combinations {
    public static void main(String args[]){
        int n = 3;
        int k = 3;
        System.out.println(combine1(n, k));

    }
    public static List<List<Integer>> combine(int n, int k) {
        return combine_huisu(n, k, 1);
    }
    public static List<List<Integer>> combine_huisu(int n, int k, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k == 1){
            for(int i = start; i <= n; i++)
                res.add(new ArrayList<>(Arrays.asList(i)));
        }
        if(k >= 2 && k <= n){
            for(int i = start; i < n; i++){
                List<List<Integer>> temp = combine_huisu(n, k - 1, i + 1);
                for(List<Integer> p: temp){
                    p.add(0, i);
                }
                res.addAll(temp);
            }
        }
        return res;
    }
//    public static List<List<Integer>> combine1(int n, int k) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        for(int i = 1; i <= n; i++){
//            if(k == 1)
//                res.add(new ArrayList<>(Arrays.asList(i)));
//            else{
//                for(int j = i + 1; j <= n - k + 2; j++){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(i);
//                    for(int t = j; t <= j + k - 2; t++){
//                        temp.add(t);
//                    }
//                    res.add(temp);
////                    System.out.println(res);
//                }
//            }
//        }
//        return res;
//    }


    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int arr[] = new int[k];//存放组合的可能
        int i = 0;
        while (i >= 0) {
            arr[i]++;
            if (arr[i] > n) {
                i--;
            } else if (i == k - 1) {
                List<Integer> temp = new ArrayList<>();
                for(int j=0;j<arr.length;j++)
                    temp.add(arr[j]);
                res.add(temp);
            } else {
                i++;
                arr[i] = arr[i - 1];
            }
        }
        return res;
    }
}
