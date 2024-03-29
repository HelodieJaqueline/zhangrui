package com.zhangrui.study.algorithms.array;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 */
public class MissingNumber {

    /**
     * 完整的数组元素之和减去当前数组之和
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return -1;
        }
        //完整的数组元素之和
        int sum = ((0 +length) * (length + 1)) / 2;
        //当前数组元素之和
        int numSum = 0;
        for (int num : nums) {
            numSum += num;
        }
        return sum - numSum;
    }

    /**
     * 完整的数组异或当前数组。相同的元素异或结果为0，则最后只剩下缺失的元素
     * @param nums
     * @return
     */
    public static int missingNumberForXOR(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }

    public static int missingNumberForSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumberForXOR(new int[]{3,0,1}));
        System.out.println(missingNumberForXOR(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumberForSort(new int[]{3,0,1}));
        System.out.println(missingNumberForSort(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
