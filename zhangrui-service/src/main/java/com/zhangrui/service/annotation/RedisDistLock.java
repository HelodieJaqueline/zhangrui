package com.zhangrui.service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @description: 基于Redisson实现分布式锁注解
 * @author: ZhangRui
 * @create: 2020-01-09 10:32
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisDistLock {

    /**
     * 分布式锁Key
     */
    String key();

    /**
     * 是否在给定时间内释放锁
     * @return
     */
    boolean releaseWithTime() default false;

    /**
     * 持有锁的最长时间
     */
    long leaseTime() default 10;

    /**
     * 持有锁的最长时间单位
     * @return
     */
    TimeUnit unit() default TimeUnit.SECONDS;

}
