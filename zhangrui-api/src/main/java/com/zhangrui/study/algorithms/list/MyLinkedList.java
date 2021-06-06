package com.zhangrui.study.algorithms.list;


/**
 * @description: 链表
 * @author: ZhangRui
 * @create: 2021-05-28 10:58
 **/
public class MyLinkedList<E> {

    /**
     * 头结点
     */
    private Node<E> head;


    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public MyLinkedList() {
        this.head = null;
    }

    private static class Node<E> {

        private E value;

        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public void add(E e) {
        // TODO:
        Node<E> n = new Node<E>(e);
        if (head == null) {

        }
    }

}
