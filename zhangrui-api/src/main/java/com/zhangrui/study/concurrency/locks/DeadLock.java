package com.zhangrui.study.concurrency.locks;

/**
 * @description: 死锁
 * @author: ZhangRui
 * @create: 2021-05-25 14:17
 **/
public class DeadLock implements Runnable{


    static class MyLock{

        public static Object obj1 = new Object();

        public static Object obj2 = new Object();


    }

    @Override
    public void run() {

    }
}
