package com.zhangrui.study.algorithms.sort;

/**
 * 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系。
 * 使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好。
 * 排序算法的成本模型是比较和交换的次数。
 */
public abstract class Sort<T extends Comparable<T>> {

    /**
     * 子类实现排序细节
     * @param nums
     */
    public abstract void sort(T[] nums);

    /**
     * 判断前者是否小于后者
     * @param v
     * @param w
     * @return v less than w
     */
    protected final boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换第i和第j个元素
     * @param a 待排序数组
     * @param i index i
     * @param j index j
     */
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
