package com.zhangrui.study.algorithms.array;

import java.util.Arrays;

public class MSNumber {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int result = 1;
        int i = A[0];
        boolean find = false;
        for (int j = 1; j < A.length; j++) {
            if (A[j] > 0 && (A[j] - i) > 1) {
                result = i + 1;
                find = true;
            }
            i = A[j];
        }
        return find ? result : (i < 0 ? 1 : i + 1);
    }

    public static void main(String[] args) {

    }

}
