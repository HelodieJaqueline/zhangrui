package com.zhangrui.utils;

import java.time.LocalDate;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-03-28-17:41
 * @Description: Token加密
 * @Modified: By
 */
public class AuthTokenUtils {

	public static final String SEPARATOR = "#";

	/**
	 * 获取token
	 *
	 * @param data      需要加密的数据，如uid
	 * @param key       秘钥
	 * @param timeStamp 时间戳 十六进制
	 * @return token
	 */
	public static String getToken(String data, String key, String timeStamp) {
		String md5Sum = DigestUtils.md5Hex(data + key + timeStamp);
		return new StringBuilder(64).append(md5Sum).append(SEPARATOR).append(timeStamp).append(SEPARATOR).append(data).toString();
	}

	public static void main(String[] args) {
/*		String token = getToken("1981233211", "GlGJssyQYhfBQz", Long.toHexString(System.currentTimeMillis()));
		System.out.println(token);*/
		String time = LocalDate.now().toString();
		System.out.println(time);
		System.out.println(DigestUtils.md5Hex(time));
	}
}
