package com.zhangrui.study.common;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-07-11:06
 * @Description: 交换两个int(integer的值)
 * @Modified: By
 */
@Slf4j
public class SwapInteger {

	public static void main(String[] args)
		throws NoSuchFieldException, IllegalAccessException {
		Integer a = 1, b = 2;
		log.info("before a={},b={}", a, b);
		swap(a, b);
		log.info("after a={},b={}", a, b);
		int c = 1, d = 2;
		swapInt(c, d);
		log.info("c={},d={}", c, d);
	}

	private static void swap(Integer a, Integer b)
		throws NoSuchFieldException, IllegalAccessException {
		Field field = Integer.class.getDeclaredField("value");
		field.setAccessible(true);
		Integer tempa = new Integer(a.intValue());
		field.set(a, b);
		field.set(b, tempa);
	}

	private static void swapInt(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

}
