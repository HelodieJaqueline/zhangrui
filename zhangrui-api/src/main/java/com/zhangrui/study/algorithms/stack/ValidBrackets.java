package com.zhangrui.study.algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zhangrui
 * @Description:
 * @Date: 2021/12/10 11:59
 */
public class ValidBrackets {

    public static boolean valid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Deque<Character> brackets = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '{') {
                brackets.push('}');
            } else if (c == '[') {
                brackets.push(']');
            } else if (c == '(') {
                brackets.push(')');
            } else if (brackets.isEmpty() || brackets.pop() != c) {
                return false;
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(valid("{}()"));
        System.out.println(valid("{]()"));
        System.out.println(valid("{[()]}"));
        System.out.println(valid("{[[)]}"));
    }
}
