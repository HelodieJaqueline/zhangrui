package com.zhangrui.jvm;

import org.apache.commons.lang.StringUtils;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-02-20-19:50
 * @Description:
 * @Modified: By
 */
public class TestClassLodader {
	public static void main(String[] args) {
		System.out.println(StringUtils.class.getClassLoader());
		System.out.println(TestClassLodader.class.getClassLoader());
		System.out.println(System.class.getClassLoader());
	}
}
