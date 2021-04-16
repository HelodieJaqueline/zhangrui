package com.zhangrui.controller.jvm;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
/*        System.out.println(thread.isInterrupted());*/
    }
}
