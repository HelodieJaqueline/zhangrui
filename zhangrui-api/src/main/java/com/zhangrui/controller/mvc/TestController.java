package com.zhangrui.controller.mvc;

import com.zhangrui.domain.request.OpenRegisterParam;
import com.zhangrui.model.TestAopRequest;
import com.zhangrui.model.User;
import com.zhangrui.service.ITestService;
import com.zhangrui.service.IUserService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@Validated
public class TestController {

	@Autowired
	IUserService userService;

	@Autowired
	ITestService testService;

	@RequestMapping(value = "test")
	@ResponseBody
	public User test(HttpServletRequest request, HttpServletResponse response, String uid,
		@NotNull(message = "id不能为空") Long id) {
		User user = userService.getById(id);
		log.info("###########{}#############", user.toString());
		return user;
	}

	@RequestMapping(value = "testAop")
	@ResponseBody
	public User testAop(HttpServletRequest request, HttpServletResponse response, TestAopRequest testAopRequest) {
		User user = new User();
		user.setName("张三");
		user.setCreateDate(new Date());
		return user;
	}


	@RequestMapping(value = "testOutOfMemoryError")
	@ResponseBody
	public void testOutOfMemoryError(HttpServletRequest request, HttpServletResponse response, Integer count) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		String test = "testttttttttttttttttttttttttttt";
		for (int i = 0; i < count; i++) {
			map.put(i, test + i);
		}
	}

	@RequestMapping(value = "testStrategy")
	@ResponseBody
	public void testStrategy(OpenRegisterParam request) throws Exception {
		testService.testStrategy(request);
	}


	@RequestMapping(value = "/testAsync")
	@ResponseBody
	public void testAsync() {
		System.out.println("Controller主线程:" + Thread.currentThread().getName());
		testService.testAsync();
	}
}
