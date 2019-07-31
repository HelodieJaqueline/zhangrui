package com.zhangrui.algorithms.string;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-07-31-16:13
 * @Description:
 * @Modified: By
 */
public class TitleToNumber {

	public static int titleToNumber(String s) {
		if (null == s || s.length() < 1) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int length = chars.length;
		int result = 0;
		for (int i = 0; i < length; i++) {
			result += Math.pow(26, length - i - 1) * (chars[i] - 64);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("ZY"));
	}
}
