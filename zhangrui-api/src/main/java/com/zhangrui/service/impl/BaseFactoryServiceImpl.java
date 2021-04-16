package com.zhangrui.service.impl;

import com.zhangrui.domain.IRequest;
import com.zhangrui.service.IFactoryService;
import org.springframework.stereotype.Service;

@Service
public class BaseFactoryServiceImpl implements IFactoryService {

    @Override
    public void send(IRequest request) {
        System.out.println("send nothing!");
    }
}
