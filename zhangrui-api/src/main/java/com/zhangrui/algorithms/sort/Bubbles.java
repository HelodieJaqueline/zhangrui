package com.zhangrui.algorithms.sort;

public class Bubbles {


    public static void main(String[] args) {
        int[] nums = new int[]{15555,0, 5, 1, 3, 4, -1, 100, 20, 6, 28};
        sort(nums);
        System.out.println(nums.toString());
    }


    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                 if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
