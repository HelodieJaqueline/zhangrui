package com.zhangrui.study.algorithms.array;

/**
 * @description:
 * Given an integer array nums, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 * @author: rui.zhang
 * @create: 2022-03-12 22:31
 */
public class NumArray {

    private int[] preNums;

    public NumArray(int[] nums) {
      this.preNums = new int[nums.length + 1];
      for (int i = 1; i < preNums.length; i++) {
          preNums[i] = nums[i - 1] + preNums[i - 1];
      }
    }

    /**
     * 最笨的方法，直接循环遍历
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return preNums[right + 1] - preNums[left];
    }

}