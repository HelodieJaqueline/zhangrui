package com.zhangrui.algorithms.array;

/**
 * @description:
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * Return the number of good pairs.
 * @author: ZhangRui
 * @create: 2020-08-26 09:46
 **/
public class NumIdenticalPairs {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3}));
    }


    public static int numIdenticalPairs(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
