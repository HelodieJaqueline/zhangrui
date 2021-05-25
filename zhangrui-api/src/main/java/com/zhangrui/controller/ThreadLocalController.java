package com.zhangrui.controller;

import com.alibaba.ttl.TtlRunnable;
import com.zhangrui.config.InheritableContext;
import com.zhangrui.service.ThreadLocalService;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 线程池传递
 * @author: ZhangRui
 * @create: 2021-05-25 14:53
 **/
@RestController
@Slf4j
public class ThreadLocalController {

    @Resource
    private ThreadLocalService threadLocalService;

    @Autowired
    private Executor taskExecutor;

    @GetMapping(value = "/threadLocal")
    public String threadLocal(Long tenantId) {
        InheritableContext.set(tenantId);
        threadLocalService.threadLocal();
        threadLocalService.asyncThreadLocal();
        //taskExecutor.execute(TtlRunnable.get(this::doTaskExecutor));
        taskExecutor.execute(this::doTaskExecutor);
        return String.valueOf(tenantId);
    }

    private void doTaskExecutor() {
        log.info("TtlRunnable tenantId:{}", InheritableContext.get());
    }

}
