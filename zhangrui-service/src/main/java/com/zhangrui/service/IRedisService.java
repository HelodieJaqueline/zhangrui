package com.zhangrui.service;

/**
 * @description: redis操作
 * @author: ZhangRui
 * @create: 2020-01-09 15:39
 **/
public interface IRedisService {

    String lock(String id);

    String lockTime(String id);
}
