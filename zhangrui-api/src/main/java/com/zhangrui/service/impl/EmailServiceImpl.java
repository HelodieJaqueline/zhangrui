package com.zhangrui.service.impl;

import com.zhangrui.domain.IRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl extends BaseFactoryServiceImpl{
    @Override
    public void send(IRequest request) {
        System.out.println("send email");
    }
}
