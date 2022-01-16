package com.zhangrui.study.algorithms.array;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueArray {


    public int[] solution(int N) {
        // write your code in Java SE 8
        if (N < 1) {
            return new int[0];
        }
        int[] result = new int[N];
        if (N == 1) {
            result[0] = 1;
            return result;
        }
        HashSet<Integer> nums = new HashSet<>();
        if (N % 2 == 0) {
            find(N, result, nums, 0);
        } else {
            result[0] = 0;
            find(N, result, nums, 1);
        }
        return result;
    }

    private void find(int N, int[] result, HashSet<Integer> nums, int order) {
        int p = N / 2;
        int m = 1;
        while (m <= p) {
            if (nums.contains(m)) {
                continue;
            }
            nums.add(m);
            nums.add(-m);
            result[order] = m;
            result[order + 1] = -m;
            order += 2;
            m++;
        }
    }

    public static void main(String[] args) {
        int[] solution = new UniqueArray().solution(9);
        System.out.println(Arrays.toString(solution));
    }

}
