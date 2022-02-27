package com.ljs.collection.list;

import com.ljs.collection.Collection;

public interface List<T> extends Collection<T> {

    void addFirst(T data);

    void removeFirst();

    T get(int index);

    int size();

}
