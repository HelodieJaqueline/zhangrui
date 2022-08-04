package com.zhangrui.study.algorithms.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存算法实现
 * @param <K>
 * @param <V>
 */
public class LinkedHashMapLRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LinkedHashMapLRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        boolean isRemove = size() > this.capacity;
        if (isRemove) {
            System.out.println("清除缓存key:" + eldest.getKey());
        }
        return isRemove;
    }

    public static void main(String[] args) {
        LinkedHashMapLRUCache<String, String> cache = new LinkedHashMapLRUCache<String, String>(5);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        cache.put("5", "5");

        System.out.println("初始：");
        System.out.println(cache.keySet());
        System.out.println("访问3：");
        cache.get("3");
        System.out.println(cache.keySet());
        System.out.println("访问2：");
        cache.get("2");
        System.out.println(cache.keySet());
        System.out.println("增加数据6,7：");
        cache.put("6", "6");
        cache.put("7", "7");
        System.out.println(cache.keySet());
        do {

        } while (cache != null);
    }
}
