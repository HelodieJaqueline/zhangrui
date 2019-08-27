package com.zhangrui.service;

import com.zhangrui.domain.request.OpenRegisterParam;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-02-25-20:02
 * @Description:
 * @Modified: By
 */
public interface ITestService {
	void testStrategy(OpenRegisterParam request)
		throws Exception;

    void testAsync();

}
