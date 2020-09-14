package com.zhangrui.algorithms.list;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 单链表
 * @author: ZhangRui
 * @create: 2020-09-05 18:21
 **/
@Data
@NoArgsConstructor
public class ListNode {

    int value;

    ListNode next;

    public boolean hasNext() {
        return null != next;
    }

    public ListNode(int value) {
        this.value = value;
    }
}
