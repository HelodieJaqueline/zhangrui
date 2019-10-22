package com.zhangrui.concurrency.queue;

import java.util.concurrent.TimeUnit;

public class TestMyArrayBlockingQueue {


    public static void main(String[] args) {
        java.util.concurrent.ArrayBlockingQueue<String> queue = new java.util.concurrent.ArrayBlockingQueue<>(5);
        //生产包子
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    String e = "包子" + finalI;
                    queue.put(e);
                    System.out.println("生产了一个包子" + e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            try {
                TimeUnit.MICROSECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费包子
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    String e = queue.take();
                    System.out.println("吃掉了一个包子:" + e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            TimeUnit.MICROSECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static class Producer extends Thread {

        private int num;

        private ArrayBlockingQueue<String> queue;

        public Producer(ArrayBlockingQueue<String> queue, int num) {
            this.num = num;
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                queue.put("包子" + num);
                System.out.println("生产了一个包子");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {

        private ArrayBlockingQueue<String> queue;

        public Consumer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String e = queue.take();
                System.out.println("吃掉了一个包子:" + e);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
