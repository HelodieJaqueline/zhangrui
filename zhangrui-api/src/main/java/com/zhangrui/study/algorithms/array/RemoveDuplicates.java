package com.zhangrui.study.algorithms.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-09-28-17:21
 * @Description:
 * @Modified: By
 */
public class RemoveDuplicates {


    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the
     * new length. Do not allocate extra space for another array, you must do this by modifying the input array in-place
     * with O(1) extra memory.
     */
    public static int removeDuplicates(int[] nums) {
        Set<Integer> uniquSet = new HashSet<Integer>();
        for (int num : nums) {
            uniquSet.add(num);
        }
        return uniquSet.size();
    }

    public static int removeDuplicatesV2(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return 0;
        }
        int fast = 1, slow = 0;
        while (fast < length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicatesV2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

}
