package com.zhangrui.algorithms;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-09-30-10:46
 * @Description:
 * @Modified: By
 */
public class HammingWeight {


    public static int hammingWeight(long n) {
        return Long.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(4294967293L));
    }

}
