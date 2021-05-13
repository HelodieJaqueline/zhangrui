package com.zhangrui.core;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2021-05-13 22:06
 **/
public class MyLruCache<K, V> {

    /**
     * 缓存的最大容量
     */
    private final int maxCapacity;

    private ConcurrentHashMap<K, V> cacheMap;
    private ConcurrentLinkedQueue<K> keys;
    /**
     * 读写锁
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();

    public MyLruCache(int maxCapacity) {
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("Illegal max capacity: " + maxCapacity);
        }
        this.maxCapacity = maxCapacity;
        cacheMap = new ConcurrentHashMap<>(maxCapacity);
        keys = new ConcurrentLinkedQueue<>();
    }

    public V put(K key, V value) {
        // 加写锁
        writeLock.lock();
        try {
            //1.key是否存在于当前缓存
            if (cacheMap.containsKey(key)) {
                moveToTailOfQueue(key);
                cacheMap.put(key, value);
                return value;
            }
            //2.是否超出缓存容量，超出的话就移除队列头部的元素以及其对应的缓存
            if (cacheMap.size() == maxCapacity) {
                System.out.println("maxCapacity of cache reached");
                removeOldestKey();
            }
            //3.key不存在于当前缓存。将key添加到队列的尾部并且缓存key及其对应的元素
            keys.add(key);
            cacheMap.put(key, value);
            return value;
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key) {
        //加读锁
        readLock.lock();
        try {
            //key是否存在于当前缓存
            if (cacheMap.containsKey(key)) {
                // 存在的话就将key移动到队列的尾部
                moveToTailOfQueue(key);
                return cacheMap.get(key);
            }
            //不存在于当前缓存中就返回Null
            return null;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 将元素添加到队列的尾部(put/get的时候执行)
     */
    private void moveToTailOfQueue(K key) {
        keys.remove(key);
        keys.add(key);
    }

    /**
     * 移除队列头部的元素以及其对应的缓存 (缓存容量已满的时候执行)
     */
    private void removeOldestKey() {
        K oldestKey = keys.poll();
        if (oldestKey != null) {
            cacheMap.remove(oldestKey);
        }
    }

    public int size() {
        return cacheMap.size();
    }

    @Override
    public String toString() {
        return cacheMap.toString();
    }

    public static void main(String[] args) {
        MyLruCache cache = new MyLruCache(4);
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
