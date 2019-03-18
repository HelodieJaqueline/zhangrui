package com.zhangrui.service.impl;

import com.zhangrui.domain.request.OpenRegisterParam;
import com.zhangrui.service.IRegister;
import com.zhangrui.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-02-25-20:02
 * @Description:
 * @Modified: By
 */
@Service
public class TestServiceImpl implements ITestService {

	private static final String OPEN = "0";
	private static final String CANCEL = "1";


	@Override
	public void testStrategy(OpenRegisterParam request) throws Exception {
		getRegister(request.getState()).doRegister(request);
	}

	private IRegister getRegister(String state) throws Exception {
		return SpringBeanProxy.getBean(IRegister.class, getRegisterBeanName(state));
	}

	private String getRegisterBeanName(String state) throws Exception {
		switch (state) {
			case OPEN:
				return "openRegister";
			case CANCEL:
				return "canCelRegister";
			default:
				throw new Exception("状态不对");
		}
	}

}
