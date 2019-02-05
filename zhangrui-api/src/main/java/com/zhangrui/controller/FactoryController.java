package com.zhangrui.controller;

import com.zhangrui.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FactoryController {
    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/sendMessage")
    @ResponseBody
    public String sendMessage(String type) {
        return userService.sendMessage(type);
    }
}
