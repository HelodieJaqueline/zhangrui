package com.zhangrui.algorithms.string;

import java.util.Arrays;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-07-29-17:13
 * @Description: Given two strings s and t , write a function to determine if t is an anagram of s.
 * @Modified: By
 */
public class IsAnagram {

	public static boolean isAnagram(String s, String t) {
		if (null == s || null == t || s.length() != t.length()) {
			return false;
		}
		if (s.equals(t)) {
			return true;
		}
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		Arrays.sort(charS);
		Arrays.sort(charT);
		return String.valueOf(charS).equals(String.valueOf(charT));
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("",""));
		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("rat","car"));
	}
}
