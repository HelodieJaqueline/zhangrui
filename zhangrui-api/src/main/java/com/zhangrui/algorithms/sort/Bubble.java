package com.zhangrui.algorithms.sort;

/**
 * @Author: ZhangRui
 * @Date: Created at 2018-12-26-15:13
 * @Description: 冒泡排序
 * @Modified: By
 */
public class Bubble {

    public static int[]  bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 0, 9, 2, 7};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
