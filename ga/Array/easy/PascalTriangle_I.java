package Array.easy;

import java.util.ArrayList;
import java.util.List;

//118. Pascal's Triangle
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//        在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//        示例:
//
//        输入: 5
//        输出:
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]
public class PascalTriangle_I {
    public static void main(String args[]){
        int numRows = 5;
        System.out.println(generate(numRows));
    }
    //时间复杂度O(n*n)
    //空间复杂度O(n*n)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i< numRows; i++){
            List<Integer> in = new ArrayList<>();
            for(int j = 0 ;j <= i; j++){
                if(j == 0 || j == i)
                    in.add(1);
                else
                    in.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            res.add(in);
        }
        return res;
    }
}
