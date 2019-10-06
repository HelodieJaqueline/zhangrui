package com.zhangrui;

import org.apache.commons.lang.StringUtils;

public class Test {

    public static void main(String[] args) {
        System.out.println(Math.floor(-1.5));
        String str="int";
        String str1=new String("int");
        System.out.println(str == str1);
        System.out.println(StringUtils.reverse(str));
    }
}
