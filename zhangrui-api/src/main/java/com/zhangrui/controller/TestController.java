package com.zhangrui.controller;

import com.zhangrui.model.TestAopRequest;
import com.zhangrui.model.User;
import com.zhangrui.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@Slf4j
public class TestController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "test")
    @ResponseBody
    public User test(HttpServletRequest request, HttpServletResponse response,String uid,Long id){
        User user = userService.getById(id);
        log.info("###########{}#############",user.toString());
        return user;
    }

	@RequestMapping(value = "testAop")
	@ResponseBody
	public User testAop(HttpServletRequest request, HttpServletResponse response,TestAopRequest testAopRequest){
		User user = new User();
		user.setName("张三");
		user.setCreateDate(new Date());
		return user;
	}

	public static void main(String[] args) {
		Integer a = -128;
		Integer b = 127;
		Integer c = 1289;
		List<String> list = new ArrayList<>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
			String next = iterator.next();
			if ("赵六".equals(next)) {
				iterator.remove();
			}
		}
	}
}
