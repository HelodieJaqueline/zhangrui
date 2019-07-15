package com.zhangrui.algorithms;

import java.util.LinkedList;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int zeroCount = 0;
        LinkedList<Integer> orderList = new LinkedList<Integer>();
        for (int num : nums) {
            if (0 == num) {
                zeroCount++;
            } else {
                orderList.add(num);
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            orderList.addLast(0);
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = orderList.get(i);
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,3,2131,-23,0,5,67,0,6,0,345,43534,324,222});
    }
}
