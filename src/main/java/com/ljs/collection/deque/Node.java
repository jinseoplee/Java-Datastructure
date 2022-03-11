package com.ljs.collection.deque;

public class Node<T> {
    private T data;
    Node<T> llink;
    Node<T> rlink;

    public Node(T data) {
        this.data = data;
        this.llink = null;
        this.rlink = null;
    }

    public T getData() {
        return this.data;
    }
}