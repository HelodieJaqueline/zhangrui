package com.zhangrui.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: mybatis拦截
 * @author: ZhangRui
 * @create: 2021-04-26 16:06
 **/
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterceptAnnotation {

    /**
     * 是否拦截
     * @return
     */
    boolean flag() default  true;
}
