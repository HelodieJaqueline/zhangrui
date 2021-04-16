package com.zhangrui.study.concurrency;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-08-05-16:11
 * @Description:
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 * @Modified: By
 */
public class Foo {

	public Foo() {

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

	public static void main(String[] args) {
		Foo foo = new Foo();
		Thread thread1 = new Thread();
		Thread thread2 = new Thread();
		Thread thread3 = new Thread();
	}
}
