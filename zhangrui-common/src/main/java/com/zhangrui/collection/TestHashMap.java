package com.zhangrui.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: HashMap测试
 * @author: ZhangRui
 * @create: 2020-05-09 09:36
 **/
public class TestHashMap {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(10000);
        for (int i = 0; i < 10001; i++) {
            if (i == 9999) {
                System.out.println(111);
            }
            map.put(i, i);
        }
    }
}
