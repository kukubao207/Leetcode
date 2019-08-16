package Array.easy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//122.Best Time to Buy and Sell Stock II
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//示例 1:
//
//输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//示例 2:
//
//输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//示例 3:
//
//输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
public class BestTimetoBuyandSellStock_II {
    public static void main(String[] args){
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit_one(prices));
    }
    //贪心算法，只要今天比昨天大，就卖出
    //时间复杂度O(n)，空间复杂度O(1)
    public static int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int max = 0;
        while(i < prices.length && j < prices.length){
            if(prices[i] < prices[j]){
                max = max + (prices[j] - prices[i]);
            }
            i++;
            j++;
        }
        return max;
    }
    //暴力
    //时间复杂度O(n*n)，空间复杂度O(n)
    public static int maxProfit_one(int[] prices) {
        return calculate(prices, 0);
    }
    public static int calculate(int[] prices, int s){
        if(s >= prices.length)
            return 0;
        int max = 0;
        for(int i = s; i < prices.length; i++){
            int maxProfit = 0;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] - prices[i] > 0){
                    int profit = calculate(prices, j + 1) + prices[j] - prices[i];
                    if(maxProfit < profit)
                        maxProfit = profit;
                }
            }
            if(max < maxProfit)
                max = maxProfit;
        }
        return max;
    }
}
