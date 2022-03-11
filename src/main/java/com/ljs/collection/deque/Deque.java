package com.ljs.collection.deque;

public class Deque<T> {
    private Node<T> front;
    private Node<T> rear;

    public Deque() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return (front == null) && (rear == null);
    }

    public void insertFront(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }

        front.llink = newNode;
        newNode.rlink = front;
        front = newNode;
    }

    public void insertRear(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.rlink = newNode;
        newNode.llink = rear;
        rear = newNode;
    }

    public T deleteFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        Node<T> target = front;
        T data = target.getData();

        if (front.rlink == null) {
            front = null;
            rear = null;
        } else {
            front = front.rlink;
            front.llink = null;
            target.rlink = null;
        }

        return data;
    }

    public T deleteRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        Node<T> target = rear;
        T data = target.getData();

        if (rear.llink == null) {
            front = null;
            rear = null;
        } else {
            rear = rear.llink;
            rear.rlink = null;
            target.llink = null;
        }

        return data;
    }

    public void removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        Node<T> target = front;

        if (front.rlink == null) {
            front = null;
            rear = null;
        } else {
            front = front.rlink;
            front.llink = null;
            target.rlink = null;
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        Node<T> target = rear;

        if (rear.llink == null) {
            front = null;
            rear = null;
        } else {
            rear = rear.llink;
            rear.rlink = null;
            target.llink = null;
        }
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        return front.getData();
    }

    public T peekRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        return rear.getData();
    }
}