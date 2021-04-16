package com.zhangrui.interceptor.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: cache键
 * @author: ZhangRui
 * @create: 2020-01-10 17:21
 **/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Key {

    /**
     * key的值
     * @return
     */
    String value();
}
