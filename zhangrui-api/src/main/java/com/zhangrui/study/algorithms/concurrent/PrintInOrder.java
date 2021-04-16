package com.zhangrui.study.algorithms.concurrent;

/**
 * @description: Print in Order
 * @author: ZhangRui
 * @create: 2020-03-24 12:52
 **/
public class PrintInOrder {


    class Foo {

        public Foo() {
/*            first();
            second();
            third();*/

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
