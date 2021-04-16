package com.zhangrui.study.algorithms.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @description: 队列基础操作
 * @author: ZhangRui
 * @create: 2020-12-03 16:49
 **/
public class QueueBasic {


    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        queue.add(0);
        while (CollectionUtils.isNotEmpty(queue)) {
            System.out.println(queue.poll());
        }
    }
}
