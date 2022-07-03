package com.zhangrui.study.algorithms.list;

/**
 * @author: rui.zhang
 * @date: 2022-07-04 01:42
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 *
 *
 * Example 2:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 *
 *
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 */
public class AddTwoNumbersII {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先反转链表，然后相加
        l1 = reverse(l1);
        l2 = reverse(l2);
        //1、逢十进一
        //2、遇null补0
        //3、两个链表next都为空并且没有进位时计算完毕
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;

            int sum = carry + x + y;
            //对应位上的值
            int val = sum % 10;
            //进位
            carry = sum / 10;
            current.next = new ListNode(val);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return reverse(dummy.next);
    }

    /**
     * Reverse a singly linked list.
     * Example:
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * @param node
     * @return
     */
    private ListNode reverse(ListNode node) {
        ListNode prev = node;
        ListNode current = node.next;
        prev.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}