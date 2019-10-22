package com.zhangrui.concurrency.utils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest extends Thread{

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The current Thread Name is :" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (;;) {
            new CountDownLatchTest().start();
        }
    }
}