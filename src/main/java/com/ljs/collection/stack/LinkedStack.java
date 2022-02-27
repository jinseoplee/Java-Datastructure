package com.ljs.collection.stack;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.link = top;
        top = newNode;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        Node<T> deleteNode = top;
        top = top.link;
        deleteNode.link = null;
        return deleteNode.getData();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        T data = top.getData();
        return data;
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        Node<T> deleteNode = top;
        top = top.link;
        deleteNode.link = null;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        Node<T> pre;
        Node<T> temp = top;
        while(top != null){
            pre = top;
            top = top.link;
            pre.link = null;
        }
    }
}
