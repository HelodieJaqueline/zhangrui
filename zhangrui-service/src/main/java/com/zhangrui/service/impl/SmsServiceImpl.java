package com.zhangrui.service.impl;

import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl extends BaseFactoryServiceImpl{

    @Override
    public void send() {
        System.out.println("send sms");
    }
}
