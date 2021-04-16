package com.zhangrui.study.algorithms.string;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-07-08-9:23
 * @Description:
 * @Modified: By
 */
public class DefangIPaddr {
	private static final String REPALCEMENT = "[.]";

	private static final String REGEX = "\\.";

	/**
	 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
	 * A defanged IP address replaces every period "." with "[.]".
	 * @param address
	 * @return
	 */
	public static String defangIPaddr(String address) {
		if (null == address || 0 == address.length()) {
			throw new RuntimeException(" address is null");
		}
		return address.replaceAll(REGEX, REPALCEMENT);
	}

	public static void main(String[] args) {
		System.out.println(defangIPaddr("255.100.50.0"));
	}
}
