package com.zhangrui.service;

import com.zhangrui.domain.request.OpenRegisterParam;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-02-25-20:11
 * @Description:
 * @Modified: By
 */
public interface IRegister {

	/**
	 * 开销户
	 */
	void doRegister(OpenRegisterParam request);

}
