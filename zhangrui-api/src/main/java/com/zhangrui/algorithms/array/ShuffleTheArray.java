package com.zhangrui.algorithms.array;

import java.util.Arrays;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2020-08-17 09:51
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 **/
public class ShuffleTheArray {


    public static void main(String[] args) {
        shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
    }

    public static int[] shuffle(int[] nums, int n) {
        if (null == nums ||  nums.length== 0 || ((nums.length) % 2) != 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        int[] x = Arrays.copyOfRange(nums, 0, n);
        int[] y = Arrays.copyOfRange(nums, n, nums.length);
        int xi =0, yi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = x[xi];
                xi++;
            }else {
                result[i] = y[yi];
                yi++;
            }
        }
        return result;
    }
}
