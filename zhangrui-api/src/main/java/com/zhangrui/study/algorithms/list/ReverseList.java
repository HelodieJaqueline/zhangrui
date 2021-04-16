package com.zhangrui.study.algorithms.list;

/**
 * @description: 翻转链表
 * @author: ZhangRui
 * @create: 2020-09-05 18:21
 **/
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 2; i <= 5; i++) {
            ListNode listNode = new ListNode(i);
            next.setNext(listNode);
            next = listNode;
        }
        //System.out.println(reverseList(head));
        System.out.println(reverseBetween(head, 2, 4));
    }

    /**
     * Reverse a singly linked list.
     * Example:
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (null == head || !head.hasNext()) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = prev.getNext();
        prev.setNext(null);
        while (curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Reverse a linked list from position m to n. Do it in one-pass.
     * Note: 1 ≤ m ≤ n ≤ length of list.
     * Example:
     * Input:  1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prevM = head;
        ListNode nodeM = head.next;
        ListNode nodeN = nodeM;
        ListNode postN = nodeN.next;
        for (int i = m; i < n; i++) {
            ListNode next = postN.next;
            postN.next = nodeN;
            nodeN = postN;
            postN = next;
        }
        nodeM.next = postN;
        prevM.next = nodeN;
        return dummy.next;
    }
}
