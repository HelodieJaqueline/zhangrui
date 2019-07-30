package com.zhangrui.algorithms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SinglyLinkedNode {
    private int val;

    private SinglyLinkedNode next;

    public SinglyLinkedNode(int val) {
        this.val = val;
    }

    public void deleteNode(ListNode node) {

    }
}
