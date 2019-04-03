package com.zhangrui.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-14-10:10
 * @Description:
 * @Modified: By
 */
public class ConvertStringsAndCollection {
	public static void main(String[] args) {
		String[] arr = {"AA","BB","DD","CC","BB"};

		//数组-->Set
		List list = Arrays.asList(arr);
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
	}
}
