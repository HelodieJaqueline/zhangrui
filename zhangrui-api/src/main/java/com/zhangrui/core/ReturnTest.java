package com.zhangrui.core;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2021-06-06 22:03
 **/
public class ReturnTest {

    public static void main(String[] args) {
        System.out.println(returnTest());
    }

    public static boolean returnTest() {
        try {
            return true;
        } finally {
            return false;
        }
    }

}
