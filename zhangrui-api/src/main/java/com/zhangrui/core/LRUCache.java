package com.zhangrui.core;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @description: LRU缓存
 * @author: ZhangRui
 * @create: 2021-05-13 20:11
 **/
public class LRUCache extends LinkedHashMap {

    private int limit = 0;

    public int getLimit() {
        return limit;
    }

    public LRUCache(int limit) {
        super(limit);
        this.limit = limit;
        if (limit < 1) {
            throw new RuntimeException("缓存容量不能小于1！");
        }
    }

    @Override
    public Object get(Object key) {
        Object value = super.get(key);
        return null == value ? Integer.valueOf(-1) : value;
    }

    @Override
    public Object put(Object key, Object value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Entry eldest) {
        return this.size() > getLimit();
/*        if (this.size() > getLimit()) {
            this.remove(eldest);
            return true;
        }
        return false;*/
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
    }
}
