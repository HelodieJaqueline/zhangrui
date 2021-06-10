package com.zhangrui.core;

import java.util.Collections;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2021-06-06 22:03
 **/
public class ReturnTest {

    public static void main(String[] args) {
        System.out.println(returnTest());

        System.out.println(2 >> 1);
        Collections.synchronizedList();
    }

    public static boolean returnTest() {
        try {
            return true;
        } finally {
            return false;
        }
    }

}
