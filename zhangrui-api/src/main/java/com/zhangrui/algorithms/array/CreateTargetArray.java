package com.zhangrui.algorithms.array;

/**
 * @description:
 * Given two arrays of integers nums and index.
 * Your task is to create target array under the following rules:
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * It is guaranteed that the insertion operations will be valid.
 *
 * Example 1:
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * @author: ZhangRui
 * @create: 2020-09-09 10:11
 **/
public class CreateTargetArray {

    public static void main(String[] args) {
        createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        if (null == nums || null == index || nums.length != index.length) {
            return null;
        }
        int length = nums.length;
        int[] target = new int[length];
        for (int i = 0; i < length; i++) {
            int idx = index[i];
            int value = nums[i];
            int[] targetCopy = new int[length];
            System.arraycopy(target, 0, targetCopy, 0, length);
            for (int j = idx +1; j < length; j++) {
                target[j] = targetCopy[j - 1];
            }
            target[idx] = value;
        }
        return target;
    }
}
