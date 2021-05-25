package com.zhangrui.controller;

import com.zhangrui.service.ThreadLocalService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 线程池传递
 * @author: ZhangRui
 * @create: 2021-05-25 14:53
 **/
@RestController
public class ThreadLocalController {

    @Resource
    private ThreadLocalService threadLocalService;

    @GetMapping(value = "/threadLocal")
    public String threadLocal(Long tenantId) {
        InheritableThreadLocal<Long> inheritableThreadLocal = new InheritableThreadLocal<Long>();
        inheritableThreadLocal.set(tenantId);
        threadLocalService.threadLocal();
        threadLocalService.asyncThreadLocal();
        return String.valueOf(tenantId);
    }

}
