package com.zhangrui.study.algorithms.list;

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

    public int val;

    public ListNode next;

    public boolean hasNext() {
        return null != next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
