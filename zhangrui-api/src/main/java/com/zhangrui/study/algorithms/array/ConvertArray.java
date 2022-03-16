package com.zhangrui.study.algorithms.array;

import java.util.Arrays;

/**
 * 翻转数组
 * @author rui.zhang
 * @date 2022-03-13 21:38
 */
public class ConvertArray {

    public static int[] convertArray(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 8, 4, 10};
        int[] convertArray = convertArray(nums);
        System.out.println(Arrays.toString(convertArray));

    }

}