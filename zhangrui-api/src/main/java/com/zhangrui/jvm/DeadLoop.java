package com.zhangrui.jvm;

public class DeadLoop {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("dead loop !……");
        }
    }
}
