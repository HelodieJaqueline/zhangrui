package com.zhangrui.study.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: rui.zhang
 * @date: 2022-08-17 00:51
 */
public class RomanToInt {


    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);

        int result = 0;
        int last = 0;
        for(int i = s.length() -1;i >= 0;i--){
            int number = m.get(s.charAt(i));
            if(number < last){
                result-= number;
            } else {
                result+=number;
            }
            last = number;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("III"));
    }

}