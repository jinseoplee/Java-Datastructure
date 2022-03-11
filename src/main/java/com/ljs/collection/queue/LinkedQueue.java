package com.ljs.collection.queue;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public boolean isEmpty() {
        return (front == null) && (rear == null);
    }

    @Override
    public void enQueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.link = newNode;
        rear = newNode;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        Node<T> target = front;
        T data = target.getData();

        if (front.link == null) {
            front = null;
            rear = null;
        } else {
            front = front.link;
            target.link = null;
        }

        return data;
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        if (front.link == null) {
            front = null;
            rear = null;
            return;
        }

        Node<T> target = front;
        front = front.link;
        target.link = null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        return front.getData();
    }
}