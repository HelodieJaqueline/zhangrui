package com.zhangrui.study.jvm;

public class DeadLoop {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("dead loop !……");
        }
    }
}
