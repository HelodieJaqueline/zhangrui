package com.zhangrui.redis;

import java.util.concurrent.TimeUnit;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
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
    RedissonClient redissonClient;

    @PostMapping(value = "lock")
    public String lock(String id) {
        RLock lock = redissonClient.getLock(id);
        lock.lock();
        try {
            System.out.println("Do !");
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return id;
    }
}
