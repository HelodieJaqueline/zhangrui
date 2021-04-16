package com.zhangrui.study.algorithms;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-09-26-10:41
 * @Description:
 * @Modified: By
 */
public class ClimbingStairs {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps.
     * In how many distinct ways can you climb to the top?
     */

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

}
