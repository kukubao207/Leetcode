package Array.easy;

import java.util.ArrayList;
import java.util.List;

//119. Pascal's Triangle II
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//        在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//        示例:
//
//        输入: 3
//        输出: [1,3,3,1]
//        进阶：
//
//        你可以优化你的算法到 O(k) 空间复杂度吗？
public class PascalTriangle_II {
    public static void main(String args[]){
        int rowIndex = 3;
        System.out.println(getRow_one(rowIndex));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i<= rowIndex; i++){
            List<Integer> in = new ArrayList<>();
            for(int j = 0 ;j <= i; j++){
                if(j == 0 || j == i)
                    in.add(1);
                else
                    in.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            res.add(in);
        }
        return res.get(rowIndex);
    }

    public static List<Integer> getRow_one(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        for(int i = 0; i<= rowIndex; i++){
            res.clear();
            for(int j = 0 ;j <= i; j++){
                if(j == 0 || j == i)
                    res.add(1);
                else{
                    res.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre=(ArrayList<Integer>) res.clone();
        }
        return res;
    }
}
