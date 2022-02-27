package com.ljs.collection.stack;

public class ArrayStack<T> implements Stack<T> {
    private int top;
    private int size;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        this.top = -1;
        this.size = size;
        this.stack = (T[]) new Object[this.size];
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top >= size - 1;
    }


    @Override
    public void push(T data) {
        if (isFull()) {
            throw new RuntimeException("Stack is full.");
        }

        stack[++top] = data;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        return stack[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        return stack[top];
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        top--;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        top = -1;
    }
}
