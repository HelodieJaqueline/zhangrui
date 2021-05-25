package com.zhangrui.config;


import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2021-05-25 15:12
 **/
public class InheritableContext {

    private static TransmittableThreadLocal<Long> inheritableThreadLocal = new TransmittableThreadLocal<Long>();

    public static void set(Long val) {
        inheritableThreadLocal.set(val);
    }


    public static Long get() {
        return inheritableThreadLocal.get();
    }

}
