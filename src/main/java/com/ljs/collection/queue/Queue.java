package com.ljs.collection.queue;

public interface Queue<T> {

    boolean isEmpty();

    void enQueue(T data);

    T deQueue();

    void delete();

    T peek();
}
