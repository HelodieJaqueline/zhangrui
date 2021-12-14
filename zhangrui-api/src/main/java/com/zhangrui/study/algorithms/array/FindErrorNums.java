package com.zhangrui.study.algorithms.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangrui
 * @Description:
 * @Date: 2021/12/14 15:46
 */
public class FindErrorNums {

    /**
     * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
     * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int error = -1;
        for (int num : nums) {
            Integer count = countMap.get(num);
            if (count == null) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, count + 1);
                error = num;
            }
        }
        int miss = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (!countMap.containsKey(i)) {
                miss = i;
                break;
            }
        }
        return new int[]{error, miss};
    }

    public static void main(String[] args) {
        int[] errorNums = findErrorNums(new int[]{3,3,1});
        System.out.println(Arrays.toString(errorNums));
    }
}
