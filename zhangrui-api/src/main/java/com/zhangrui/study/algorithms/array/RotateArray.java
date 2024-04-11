package com.zhangrui.study.algorithms.array;

public class RotateArray {


    public static int[] rotate(int[] nums, int k) {
        int[] numsCopy = new int[nums.length];
        int start = nums.length - k;
        for (int i = 0; i < k; i++) {
            numsCopy[i] = nums[start + i];
        }
        for (int i = k; i < nums.length; i++) {
            numsCopy[i] = numsCopy[i - k];
        }
        return numsCopy;
    }

    public static void main(String[] args) {
        System.out.println(rotate(new int[]{1, 2, 3, 4, 5, 6, 7},3));
    }

}
