package com.ljs.collection.list;

public class CircularLinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    public CircularLinkedList() {
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
            newNode.link = head;
            size++;
            return;
        }

        Node<T> lastNode = getLastNode();
        newNode.link = head;
        head = newNode;
        lastNode.link = head;
        size++;
    }

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            newNode.link = head;
            size++;
            return;
        }

        Node<T> lastNode = getLastNode();
        lastNode.link = newNode;
        newNode.link = head;
        size++;
    }

    @Override
    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> preNode = search(index - 1);
        Node<T> nextNode = search(index);
        preNode.link = newNode;
        newNode.link = nextNode;
        size++;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (head.link == head) {
            head.link = null;
            head = null;
            size--;
            return;
        }

        Node<T> lastNode = getLastNode();
        Node<T> firstNode = head;
        head = head.link;
        lastNode.link = head;
        firstNode.link = null;
        size--;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (head.link == head) {
            head.link = null;
            head = null;
            size--;
            return;
        }

        Node<T> pre = head;
        Node<T> temp = head.link;
        while (temp.link != head) {
            pre = temp;
            temp = temp.link;
        }
        pre.link = head;
        temp.link = null;
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

        Node<T> preNode = search(index - 1);
        Node<T> deleteNode = search(index);
        preNode.link = deleteNode.link;
        deleteNode.link = null;
        size--;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        Node<T> pre;
        Node<T> temp = head;
        while (temp.link != head) {
            pre = temp;
            temp = temp.link;
            pre.link = null;
        }
        temp.link = null;
        head = null;
        size = 0;
    }

    /*
     * receive the index and return the node's data
     */
    @Override
    public T get(int index) {
        Node<T> node = search(index);
        return node.getData();
    }

    /*
     * receive the index and return the node
     */
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

    /*
     * find the last node
     */
    private Node<T> getLastNode() {
        Node<T> temp = head;
        while (temp.link != head) {
            temp = temp.link;
        }
        return temp;
    }
}