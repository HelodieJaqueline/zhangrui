package com.zhangrui.study.algorithms.string;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author: rui.zhang
 * @date: 2022-08-04 15:30
 */
public class FirstRepeatedWord {


    public static String firstRepeatedWord(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s," ,-;:.");
        Set<String> set = new HashSet<>();
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            if (set.contains(token)) {
                return token;
            } else {
                set.add(token);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String a = "I hava a word have word af jl,a-j.abcd;12:312  af";

        String b = "I hava a world have word af jl,ab-j.abcd;12:312  afc";
        System.out.println(firstRepeatedWord(b));
    }

}