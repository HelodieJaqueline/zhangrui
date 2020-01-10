package com.zhangrui.redis;

import com.zhangrui.service.IRedisService;
import com.zhangrui.service.annotation.AopLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis
 */
@RestController
@RequestMapping(value = "redis")
public class RedisController {

    @Autowired
    private IRedisService redisService;

    @PostMapping(value = "lock")
    @AopLog
    public String lock(String id) {
        return redisService.lock(id);
    }

    @PostMapping(value = "lockTime")
    @AopLog
    public String lockTime(String id) {
        return redisService.lockTime(id);
    }
}
