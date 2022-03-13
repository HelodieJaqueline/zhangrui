package com.zhangrui.study.algorithms.array;

import java.util.Arrays;

/**
 * 翻转数组
 * @author rui.zhang
 * @date 2022-03-13 21:38
 */
public class ConvertArray {

    public static void convertArray(int[] nums){
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        convertArray(nums);
        System.out.println(Arrays.toString(nums));

    }

}