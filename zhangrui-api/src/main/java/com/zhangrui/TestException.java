package com.zhangrui;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-09-11-15:40
 * @Description:
 * @Modified: By
 */
public class TestException {


    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("测试异常");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
