package com.zhangrui.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: Redis的list操作
 * @author: rui.zhang
 * @create: 2022-02-28 22:20
 */
@Component
public class RedisListOps {

    private static final String LIST_KEY = "rui:zhang:list";

    @Autowired
    private RedisTemplate redisTemplate;

    public void push() {
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForList().leftPush(LIST_KEY, i);
        }
    }

    public void pop() {
        Long size = redisTemplate.opsForList().size(LIST_KEY);
        for (int i = 0; i < size; i++) {
            Integer o = (Integer) redisTemplate.opsForList().rightPop(LIST_KEY);
            System.out.println(o);
        }
    }

    public void range() {
        List<Integer> range = (List<Integer>) redisTemplate.opsForList().range(LIST_KEY, 0, 1);
        for (Integer integer : range) {
            System.out.println(integer);
        }

    }

}