package com.zhangrui.study.algorithms.string;

/**
 * @Author: YSTen
 * @Date: Created at 2019-06-25-16:07
 * @Description:
 * @Modified: By
 */
public class ToLowerCase {

	public static String toLowerCase(String str) {
		if (null == str) {
			throw new NullPointerException();
		}
		char[] chars = str.toCharArray();
		int length = chars.length;
		for (int i = 0; i < length; i++) {
			if (65 <= chars[i] && chars[i] <= 90) {
				chars[i] = (char)(chars[i] + 32);
			}
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		System.out.println(toLowerCase("asdaDFE1"));
	}
}
