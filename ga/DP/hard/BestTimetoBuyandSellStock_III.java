package DP.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//123. Best Time to Buy and Sell Stock III
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//        设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
//        注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//        示例 1:
//
//        输入: [3,3,5,0,0,3,1,4]
//        输出: 6
//        解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//        随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
//        示例 2:
//
//        输入: [1,2,3,4,5]
//        输出: 4
//        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//        注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//        因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//        示例 3:
//
//        输入: [7,6,4,3,1]
//        输出: 0
//        解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
public class BestTimetoBuyandSellStock_III {
    public static void main(String[] args) {
        int prices[] = {1, 4, 2};
        System.out.println(maxProfit_two(prices));
    }

    //只要今天比昨天的利润大，就将这两天连接，相当于选择所有线段中最长的两条线
    //时间复杂度O(n*n*n*n)
    //空间复杂度O(n)
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int res[] = new int[prices.length - 1];//存放线段的长度，即利润大小
        int k = 0;//第几条线段(正的)
        int t = 0;//（负的）
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] >= prices[i]) {
                if (i >= 1 && prices[i] < prices[i - 1])
                    k = t + 1;
                res[k] = res[k] + (prices[i + 1] - prices[i]);
            } else {
                if (i >= 1 && prices[i] >= prices[i - 1])
                    t = k + 1;
                res[t] = res[t] + (prices[i + 1] - prices[i]);
            }
        }
//        System.out.println(Arrays.toString(res));
        if (res.length == 1) {
            if (res[0] < 0)
                return 0;
            return res[0];
        } else {
            int max = 0;
            for (int i = 0; i < res.length; i++) {
                int temp1 = 0;
                for (int j = i; j < res.length; j++) {
                    temp1 = temp1 + res[j];
                    if (max < temp1)
                        max = temp1;
                    for (int q = j + 1; q < res.length; q++) {
                        int temp2 = 0;
                        for (int p = q; p < res.length; p++) {
                            temp2 = temp2 + res[p];
                            if (max < temp1 + temp2)
                                max = temp1 + temp2;
                        }
                    }
                }
            }
            return max;
        }
    }

    /**
     * 对于任意一天考虑四个变量:
     * fstBuy: 在该天第一次买入股票可获得的最大收益
     * fstSell: 在该天第一次卖出股票可获得的最大收益
     * secBuy: 在该天第二次买入股票可获得的最大收益
     * secSell: 在该天第二次卖出股票可获得的最大收益
     * 分别对四个变量进行相应的更新, 最后secSell就是最大
     * 收益值(secSell >= fstSell)
     **/
    //时间复杂度O(n)
    //空间复杂度O(1)
    public static int maxProfit_one(int[] prices) {
        int fstBuy = Integer.MIN_VALUE;
        int fstSell = 0;
        int secBuy = Integer.MIN_VALUE;
        int secSell = 0;
        for (int i = 0; i < prices.length; i++) {
            fstBuy = Math.max(fstBuy, -prices[i]);
            fstSell = Math.max(fstSell, fstBuy + prices[i]);
            secBuy = Math.max(secBuy, fstSell - prices[i]);
            secSell = Math.max(secSell, secBuy + prices[i]);
        }
        return secSell;
    }
    //时间复杂度O(n)
    //空间复杂度O(n)
    public static int maxProfit_two(int[] prices) {
        // a[i] 表示 从0 ~ i 之间，只做一次买卖的最大利润
        int min = prices[0];
        int a[] = new int[prices.length];
        a[0] = 0;
       for(int i = 1; i < prices.length; i++){
           if(min > prices[i])
               min = prices[i];
           a[i] = Math.max(a[i - 1], prices[i] - min);
       }
        // b[i] 表示 从i ~ 最后，只做一次买卖的最大利润
        int max = prices[prices.length - 1];
        int b[] = new int[prices.length];
        b[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--){
            if(max < prices[i])
                max = prices[i];
            b[i] = Math.max(b[i + 1], max - prices[i]);
        }
        // 最大利润 为 a[i]+b[i + 1]的最大值
        int res = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(a[i] + b[i + 1] > res)
                res = a[i] + b[i + 1];
        }
        return Math.max(res, a[prices.length - 1]);
    }
}
