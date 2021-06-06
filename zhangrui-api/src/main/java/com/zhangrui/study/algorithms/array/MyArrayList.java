package com.zhangrui.study.algorithms.array;

import java.util.Arrays;

/**
 * @description: ArrayList
 * @author: ZhangRui
 * @create: 2021-05-27 15:03
 **/
public class MyArrayList<E> {

    public static final int INITIAL_CAPACITY = 10;
    /**
     * 存储的元素
     */
    private Object[] elements;

    private int size;

    public MyArrayList() {
        this(INITIAL_CAPACITY);
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    /**
     * 新增元素
     * @param e
     */
    public void add(E e) {
        //如果满了，需要扩容
        //不用(size +1) > elements.length,防止溢出
        int length = elements.length;
        if (length == 0) {
            elements = new Object[10];
        }
        if ((size + 1) - length >= 0) {
            //扩容为初始的两倍
            elements = Arrays.copyOf(elements, length * 2);
        }
        if (size == 0) {
            elements[0] = e;
        } else {
            elements[size + 1] = e;
        }
        size++;
    }

    /**
     * 获取元素
     * @param i
     * @return
     */
    @SuppressWarnings("unchecked")
    public E get(int i) {
        return (E) elements[i];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(-1);
        System.out.println(myArrayList.size);
        System.out.println(myArrayList.toString());
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList.size);
        System.out.println(myArrayList.toString());
    }
}
