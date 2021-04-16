package com.zhangrui.study.algorithms.stack;

import java.util.Stack;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @description: 栈的基本操作
 * @author: ZhangRui
 * @create: 2020-12-03 16:33
 **/
public class StackBasic {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (CollectionUtils.isNotEmpty(stack)) {
            System.out.println(stack.pop());
        }
    }

}
