package com.zhangrui.study.algorithms.string;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: rui.zhang
 * @date: 2022-08-04 15:58
 */
public class BetterCompress {


    public static String betterCompress(String s) {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        char[] chars = s.toCharArray();
        char lastChar = chars[0];
        int count = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || Character.isLetter(chars[i])) {
                if (map.containsKey(lastChar)) {
                    map.put(lastChar, map.get(lastChar) + count);
                } else {
                    map.put(lastChar, count);
                }
                count = 0;
                if (i < chars.length) {
                    lastChar = chars[i];
                }
            } else {
                count = count * 10 + chars[i] - '0';
            }
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((key,value) ->{
            sb.append(key).append(value);
        });
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(betterCompress("a12b56c1"));
    }
}