package BackTracking;
//51. N-Queens
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//上图为 8 皇后问题的一种解法。
//
//给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
//每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//示例:
//
//输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String args[]){
       int n = 8;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<int[]> res = new ArrayList<int[]>();
        List<List<String>> sol = new ArrayList<List<String>>();
        int[] position = new int[n + 1];
        String str = "";
        for(int i = 0; i < n; i++)
            str = str + ".";
        queen(res, position, 1, n);
        for(int[] r: res){//一个r代表一个解
            List<String> ss = new ArrayList<String>();
            for(int p: r){//代表每个解的每一行
                if (p != 0){
                    StringBuilder strBuilder = new StringBuilder(str);
                    strBuilder.setCharAt(p - 1, 'Q');
                    ss.add(strBuilder.toString());
                }
            }
            sol.add(ss);
        }
        return sol;
    }
    public static boolean is_ok(int[] position, int row){
        for(int i = 1; i  < row; i++){
            if(position[i] == position[row] || Math.abs(position[i] - position[row]) == row - i){//保证不在同一行，这种情况不用考虑
                return false;
            }
        }
        return true;
    }
    public static void queen(List<int[]> res, int[] position, int row, int n) {
        if(row == n + 1){//一种解法生成
            res.add(position);//最后输出的res不知道是什么鬼 感觉又覆盖, position感觉可以正确记录位置
            System.out.println(Arrays.toString(position));
        }
        else{
            for(int col = 1; col <= n; col++){//循环列
                position[row] = col;//row行col列放置皇后
                if(is_ok(position, row)){
                    queen(res, position, row + 1, n);
                }
            }
        }
    }
}
