package com.zhangrui.service.impl;

import com.zhangrui.service.IRedisService;
import com.zhangrui.interceptor.annotation.RedisDistLock;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

/**
 * @description: redis操作实现
 * @author: ZhangRui
 * @create: 2020-01-09 15:39
 **/
@Service
public class RedisServiceImpl implements IRedisService {

    private static final String LOCK_PREFIX = "test";

    @Override
    @RedisDistLock(key = LOCK_PREFIX)
    public String lock(String id) {
        System.out.println("获取到锁了！");
        throw new RuntimeException("测试异常");
/*        try {
            System.out.println("获取到锁了！");
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //return id;
    }

    @Override
    @RedisDistLock(key = LOCK_PREFIX + "#id", releaseWithTime = true)
    public String lockTime(String id) {
        try {
            System.out.println("获取到锁了！");
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return id;
/*        System.out.println("获取到锁了！");
        throw new RuntimeException("测试异常");*/
    }
}
