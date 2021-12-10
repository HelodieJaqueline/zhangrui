package com.zhangrui.study.algorithms.lru;

import java.util.HashMap;

/**
 * @Author: zhangrui
 * @Description:
 * @Date: 2021/12/9 16:05
 */
public class LRUCache {

    private HashMap<Integer, Node> map;

    private DoubleNode cache;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleNode();
    }

    public static class Node {
        public int k;

        public int v;

        public Node prev,next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public static class DoubleNode{
        public Node head,tail;

        public int size;

        public DoubleNode() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void delete(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node deleteFirst() {
            if (tail == head) {
                return null;
            }
            Node val = head.next;
            delete(val);
            return val;
        }
    }


    public void put(int key, int value) {
        //缓存是否已滿
        if (cache.size == capacity) {
            //缓存已满，淘汰第一个
            Node node = cache.deleteFirst();
            map.remove(node.k);
        }
        Node node = map.get(key);
        if (null != node) {
            //删除该元素
            cache.delete(node);
            map.remove(key);
        } else {
            node = new Node(key, value);
        }
        //将元素加入到队尾
        cache.addLast(node);
        map.put(key, node);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (null == node) {
            return -1;
        }
        //将key对应的元素移到队尾
        cache.delete(node);
        cache.addLast(node);
        return node.v;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.cache);
        lruCache.get(1);
        System.out.println(lruCache.cache);
        lruCache.put(4, 4);
        System.out.println(lruCache.cache);
    }

}
