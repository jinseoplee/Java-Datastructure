package com.ljs.collection.queue;

public class ArrayCircularQueue<T> implements Queue<T> {
    private int front;
    private int rear;
    private int queueSize;
    private T[] queue;

    @SuppressWarnings("unchecked")
    public ArrayCircularQueue(int queueSize) {
        this.front = 0;
        this.rear = 0;
        this.queueSize = queueSize;
        this.queue = (T[]) new Object[this.queueSize];

    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % this.queueSize == front;
    }

    @Override
    public void enQueue(T data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        }

        rear = (rear + 1) % this.queueSize;
        queue[rear] = data;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        front = (front + 1) % this.queueSize;
        T data = queue[front];
        queue[front] = null;
        return data;
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        front = (front + 1) % this.queueSize;
        queue[front] = null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        return queue[(front + 1) % this.queueSize];
    }
}
