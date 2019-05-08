package PermutationAndCombinations;

import java.util.ArrayList;
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

    //小可爱我爱你
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = new int[k];

        int i=0;
        while(i>=0){
            arr[i]++;
            if(arr[i]>n)
                i--;
            else if(i==k-1){
                List<Integer> temp = new ArrayList<>();
                for(int j=0;j<arr.length;j++)
                    temp.add(arr[j]);
                res.add(temp);
            }
            else{
                i++;
                arr[i]=arr[i-1];
            }

        }
        return res;
    }
}
