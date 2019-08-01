package com.zhangrui.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-08-01-17:02
 * @Description:
 * @Modified: By
 */
public class FirstUniqChar {

	public static int firstUniqChar(String s) {
		if (null == s || s.length() < 1) {
			return -1;
		}
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char value = s.charAt(i);
			countMap.put(value, countMap.getOrDefault(value, 0) + 1);
		}
		for (int i = 0; i < length; i++) {
			if (countMap.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
}
