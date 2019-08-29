package com.zhangrui.algorithms.array;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-08-09-9:22
 * @Description:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * @Modified: By
 */
public class MaxProfitForOne {


    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                int profit = prices[i] - prices[j];
                if (profit > 0) {
                    maxprofit = Math.max(maxprofit, profit);
                }
            }
        }
        return maxprofit;
    }

    /**
     * 记录并更新最小价格及最大收益
     * @param prices
     * @return
     */
    public static int maxProfitAdvance(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if ((prices[i] - min) > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,3,5,1,6,4};
        System.out.println(maxProfitAdvance(prices));
        int[] prices1 = new int[]{7,6,4,3,1};
        System.out.println(maxProfitAdvance(prices1));
    }

}
