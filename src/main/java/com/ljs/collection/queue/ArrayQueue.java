package com.ljs.collection.queue;

public class ArrayQueue<T> implements Queue<T> {
    private int front;
    private int rear;
    private int queueSize;
    private T[] queue;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int queueSize) {
        this.front = -1;
        this.rear = -1;
        this.queueSize = queueSize;
        this.queue = (T[]) new Object[this.queueSize];
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == queueSize - 1;
    }

    @Override
    public void enQueue(T data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        }

        queue[++rear] = data;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        T data = queue[++front];
        queue[front] = null;
        return data;
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        queue[++front] = null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        return queue[front + 1];
    }
}