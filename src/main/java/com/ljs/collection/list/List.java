package com.ljs.collection.list;

public interface List<T> {

    boolean isEmpty();

    int size();

    void addFirst(T data);

    void add(T data);

    void add(int index, T data);

    void removeFirst();

    void remove();

    void remove(int index);

    void clear();

    T get(int index);

}
