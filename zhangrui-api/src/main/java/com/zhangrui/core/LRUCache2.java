package com.zhangrui.core;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @description: LRU缓存
 * @author: ZhangRui
 * @create: 2021-05-13 20:48
 **/
public class LRUCache2 {

    private final int limit;

    private final Queue<Integer> queue;

    private final HashMap<Integer, Object> map;

    public LRUCache2(int limit) {
        if (limit < 1) {
            throw new RuntimeException("缓存容量不能小于1！");
        }
        this.limit = limit;
        queue = new ArrayDeque<Integer>();
        map = new HashMap<>(limit);
    }

    public Object get(Integer key) {
        if (map.containsKey(key)) {
            moveToTail(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(Integer key, Object value) {
        //热点key往后移动
        if (map.containsKey(key)) {
            moveToTail(key);
            map.put(key, value);
            return;
        }
        if (map.size() == limit) {
            //移除最老的
            Integer old = queue.poll();
            if (null != old) {
                map.remove(old);
            }
        }
        queue.add(key);
        map.put(key, value);
    }

    private void moveToTail(Integer key) {
        queue.remove(key);
        queue.add(key);
    }


    @Override
    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(1, 1);
        Object value = cache.get(1);
        System.out.println(value);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        Object o = cache.get(10);
        System.out.println(o);
        System.out.println(cache);
        cache.put(5, 5);
        System.out.println(cache);
        cache.put(6, 6);
        System.out.println(cache);
        cache.put(1, 1);
        System.out.println(cache);
    }

}
