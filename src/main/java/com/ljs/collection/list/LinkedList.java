package com.ljs.collection.list;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        newNode.link = head;
        head = newNode;
        size++;
    }

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        Node<T> temp = head;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = newNode;
        size++;
    }

    @Override
    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> pre = search(index - 1);
        Node<T> temp = search(index);
        pre.link = newNode;
        newNode.link = temp;
        size++;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        Node<T> temp = head;
        head = head.link;
        temp.link = null;
        size--;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (head.link == null) {
            head = null;
            size = 0;
            return;
        }

        Node<T> pre = head;
        Node<T> temp = head.link;
        while (temp.link != null) {
            pre = temp;
            temp = temp.link;
        }
        pre.link = null;
        size--;
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node<T> pre = search(index - 1);
        Node<T> temp = search(index);
        pre.link = temp.link;
        temp.link = null;
        size--;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        Node<T> pre;
        Node<T> temp = head;
        while (temp.link != null) {
            pre = temp;
            temp = temp.link;
            pre.link = null;
        }

        head = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Out of index.");
        }

        int idx = 0;
        Node<T> temp = head;
        while (idx != index) {
            idx++;
            temp = temp.link;
        }
        return temp.getData();
    }

    private Node<T> search(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Out of index.");
        }

        int idx = 0;
        Node<T> temp = head;
        while (idx != index) {
            idx++;
            temp = temp.link;
        }
        return temp;
    }
}