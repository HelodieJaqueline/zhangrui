package com.zhangrui.controller;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 限流
 * @author: ZhangRui
 * @create: 2020-01-13 14:33
 **/
@RestController
@Slf4j
public class LimitController {

    private static Semaphore semaphore = new Semaphore(100);

    @PostMapping(value = "limit")
    public String limit() {
        if (semaphore.tryAcquire()) {
            log.info("acquired!");
           // TimeUnit.SECONDS.sleep(5);
            semaphore.release();
            log.info("released!");
            return "success!";
        }else {
            log.info("当前请求次数过多，请稍后再试!");
            return "failed!";
        }
    }
}
