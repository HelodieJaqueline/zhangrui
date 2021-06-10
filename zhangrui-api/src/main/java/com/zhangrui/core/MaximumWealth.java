package com.zhangrui.core;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2021-06-10 22:36
 **/
public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for (int[] wealth : accounts) {
            int currentWealth = 0;
            for (int i : wealth) {
                currentWealth += i;
            }
            if (currentWealth > result) {
                result = currentWealth;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] accounts = new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        int i = new MaximumWealth().maximumWealth(accounts);
        System.out.println(i);
    }

}
