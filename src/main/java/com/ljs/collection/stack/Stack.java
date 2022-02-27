package com.ljs.collection.stack;

public interface Stack<T> {
    boolean isEmpty();

    void push(T data);

    T pop();

    T peek();

    void delete();

    void clear();
}
