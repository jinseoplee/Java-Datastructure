package com.ljs.collection.list;

public class DNode<T> {
    private T data;
    DNode<T> llink;
    DNode<T> rlink;

    public DNode(T data) {
        this.data = data;
        this.llink = null;
        this.rlink = null;
    }

    public T getData() {
        return this.data;
    }
}
