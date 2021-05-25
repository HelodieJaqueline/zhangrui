package com.zhangrui.service.impl;

import com.zhangrui.config.InheritableContext;
import com.zhangrui.service.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2021-05-25 14:56
 **/
@Service
@Slf4j
public class ThreadLocalServiceImpl implements ThreadLocalService {

    @Override
    public void threadLocal() {
        log.info("SYNC tenantId:{}", InheritableContext.get());
    }

    @Override
    @Async
    public void asyncThreadLocal() {
        log.info("ASYNC tenantId:{}", InheritableContext.get());
    }
}
