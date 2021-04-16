package com.zhangrui.study.algorithms.string;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-07-10-16:03
 * @Description:
 * @Modified: By
 */
public class ReverseString {

	public static void reverseString(char[] s) {
		int length = s.length;
		for (int i = 0; i < length/2; i++) {
			char temp = s[i];
			s[i] = s[length - i -1];
			s[length - i - 1] = temp;
		}
	}

	public static void main(String[] args) {
		char[] s = {'a', 'b', 'c', 'd','e'};
		reverseString(s);
	}
}
