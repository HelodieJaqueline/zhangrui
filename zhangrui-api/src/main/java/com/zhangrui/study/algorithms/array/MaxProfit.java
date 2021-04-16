package com.zhangrui.study.algorithms.array;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (null == prices || prices.length < 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int income = prices[i] - prices[i - 1];
            if (income > 0) {
                profit += income;
            }
        }
        return profit;
    }
}
