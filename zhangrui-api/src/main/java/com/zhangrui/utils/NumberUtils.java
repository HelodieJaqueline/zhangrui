package com.zhangrui.utils;

import java.math.BigDecimal;

/**
 * @description: 数字操作工具类
 * @author: ZhangRui
 * @create: 2021-01-20 14:13
 **/
public class NumberUtils {


    public static void main(String[] args) {
        System.out.println(new BigDecimal("-80").compareTo(new BigDecimal("80.00")));
        System.out.println(new BigDecimal("80").compareTo(new BigDecimal("80.01")));
        System.out.println(new Integer("-8").compareTo(new Integer("80")));
    }

}
