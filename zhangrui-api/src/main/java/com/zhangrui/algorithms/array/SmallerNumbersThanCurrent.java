package com.zhangrui.algorithms.array;

/**
 * @description:
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * @author: ZhangRui
 * @create: 2020-08-30 15:00
 **/
public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {
        smallerNumbersThanCurrent(new int[]{6, 5, 4, 8});

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
