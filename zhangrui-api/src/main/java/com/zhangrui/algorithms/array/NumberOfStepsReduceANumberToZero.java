package com.zhangrui.algorithms.array;

/**
 * @description:
 * Given a non-negative integer num, return the number of steps to reduce it to zero.
 * If the current number is even, you have to divide it by 2,
 * otherwise, you have to subtract 1 from it.
 * @author: ZhangRui
 * @create: 2020-08-28 10:24
 **/
public class NumberOfStepsReduceANumberToZero {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }

    public static int numberOfSteps (int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            }else {
                num -=1;
            }
            steps++;
        }
        return steps;
    }
}
