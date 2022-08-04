package com.zhangrui;

import java.util.*;

import org.apache.commons.lang.StringUtils;

public class Test {

    /**
     * 左括号
     */
    private static final String LEFT_BRACKETS = "[";

    /**
     * 左括号
     */
    private static final String RIGHT_BRACKETS = "]";

    private static final Map<String, String> MAP = new HashMap<>();

    static {
        MAP.put("赠送课时数", "abc");
        MAP.put("退费赠送课时数", "def");
    }

    public static void main(String[] args) {
/*        String value = "[赠送课时数]-[退费赠送课时数]";
        String[] strings = StringUtils.substringsBetween(value, LEFT_BRACKETS, RIGHT_BRACKETS);
        System.out.println(value);
        for (String string : strings) {
            value = value.replace(LEFT_BRACKETS.concat(string).concat(RIGHT_BRACKETS),
                LEFT_BRACKETS.concat(MAP.get(string)).concat(RIGHT_BRACKETS));
        }
        System.out.println(value);*/
        String a = "I hava a word have word af jl,a-j.abcd;12:312  af";

    }
}
