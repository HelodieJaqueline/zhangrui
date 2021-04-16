package com.zhangrui.study.algorithms.array;

/**
 * @description: Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * @author: ZhangRui
 * @create: 2020-08-14 09:40
 **/
public class RunningSumOf1dArray {

    public static void main(String[] args) {
        runningSum(new int[]{3,1,2,10,1});
    }

    public static int[] runningSum(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new int[]{};
        }
        int sum = 0;
        int[] runningSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            runningSum[i] = sum;
        }
        return runningSum;
    }
}
