package com.zhangrui.study.algorithms.array;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-10-10-9:24
 * @Description:
 * @Modified: By
 */
public class MaximumSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
     * sum and return its sum.
     */
    public static int maxSubArray(int[] nums) {
        int max = 0;
        int start = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
