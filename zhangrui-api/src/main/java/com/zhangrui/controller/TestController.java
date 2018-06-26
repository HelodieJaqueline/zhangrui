package com.zhangrui.controller;

import com.zhangrui.model.User;
import com.zhangrui.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
