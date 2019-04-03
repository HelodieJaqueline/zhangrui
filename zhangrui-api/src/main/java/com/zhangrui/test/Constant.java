package com.zhangrui.test;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-07-15:07
 * @Description:
 * @Modified: By
 */
public class Constant {
	public static final String CONSTANT = "我是常量";

	static {
		System.out.println("我是静态块");
	}
}
