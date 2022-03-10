package com.ljs.collection.queue;

public class Node<T> {
    private T data;
    Node<T> link;

    public Node(T data) {
        this.data = data;
        this.link = null;
    }

    public T getData() {
        return this.data;
    }
}
