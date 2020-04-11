package com.zhangrui.zk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Zookeeper
 * @author: ZhangRui
 * @create: 2020-01-16 11:17
 **/
@RestController
@Slf4j
@RequestMapping(value = "zk")
public class ZookeeperController {

    @Autowired
    private RedisTemplate redisTemplate;

    public void test() {
    }
}
