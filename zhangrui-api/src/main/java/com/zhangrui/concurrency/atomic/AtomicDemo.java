package com.zhangrui.concurrency.atomic;

import sun.misc.Unsafe;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-19-21:17
 * @Description:
 * @Modified: By
 */
public class AtomicDemo {

	static volatile int a;

	public static void main(String[] args) {
		for (; ; ) {
			a++;
			if (Unsafe.getUnsafe().compareAndSwapInt(new AtomicDemo(), a,1000,999999999)) {
				System.out.println("final:" + a);
				break;
			}
			System.out.println(a);
		}
	}
}
