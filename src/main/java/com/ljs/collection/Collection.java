package com.ljs.collection;

public interface Collection<T> {

    boolean isEmpty();

    void add(T data);

    void add(int index, T data);

    void remove();

    void remove(int index);

    void clear();
}
