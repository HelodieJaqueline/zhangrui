package com.zhangrui.study.algorithms;

import java.util.ArrayList;

public class ClockDigital {

    public int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        int result = 0;
        if (A >= 0 && A <= 2) {
            if (A == 2) {
                if (B <= 3) {
                    result += 2;
                }
            }
        }

        if (B >= 0 && B <= 2) {

        }

        if (C >= 0 && C <= 2) {

        }

        if (D >= 0 && D <= 2) {

        }

        return result;
    }

    public static void main(String[] args) {
        new ClockDigital().solution(1, 8, 3, 2);
    }

}
