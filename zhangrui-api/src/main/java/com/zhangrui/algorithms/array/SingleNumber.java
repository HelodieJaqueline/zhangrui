package com.zhangrui.algorithms.array;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        if (null == nums || nums.length < 1) {
            throw new NullPointerException("array is null!");
        }
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1, 1, 2, 2, 3,3};
        System.out.println(singleNumber(nums));
    }
}
