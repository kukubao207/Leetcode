package BackTracking;

import java.util.ArrayList;
import java.util.List;

//52. N-Queens II
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//上图为 8 皇后问题的一种解法。
//
//给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//
//示例:
//
//输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
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
public class NQueens_II {
    public static void main(String args[]){
        int n = 1;
        System.out.println(totalNQueens(n));
    }
    public static int totalNQueens(int n) {
        int[] position = new int[n + 1];
        queen(position, 1, n);//row和col全从1开始
        return total;
    }
    public static boolean is_ok(int[] position, int row){
        for(int i = 1; i  < row; i++){
            if(position[i] == position[row] || Math.abs(position[i] - position[row]) == row - i){//保证不在同一行，这种情况不用考虑
                return false;
            }
        }
        return true;
    }
    public static int total = 0;//注意声明全局变量
    public static void queen(int[] position, int row, int n) {
        if(row == n + 1){//一种解法生成
            total++;
//            System.out.println(total);//加不起来
        }
        else{
            for(int col = 1; col <= n; col++){//循环列
                position[row] = col;//row行col列放置皇后
                if(is_ok(position, row)){
                    queen(position, row + 1, n);
                }
            }
        }
    }
}
