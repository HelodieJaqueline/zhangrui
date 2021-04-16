package com.zhangrui.study.algorithms.array;

/**
 * @description:
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * @author: ZhangRui
 * @create: 2020-08-30 15:21
 **/
public class SubtractProductAndSum {

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        String value = String.valueOf(n);
        int product = 1;
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            int number = Integer.parseInt(value.substring(i, i + 1));
            product *= number;
            sum += number;
        }
        return product - sum;
    }

}
