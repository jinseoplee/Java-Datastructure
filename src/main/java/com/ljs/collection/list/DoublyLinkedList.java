package com.ljs.collection.list;

public class DoublyLinkedList<T> implements List<T> {
    private DNode<T> head;
    private int size;

    public DoublyLinkedList() {
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
        DNode<T> newNode = new DNode<>(data);

        if (isEmpty()) {
            head = newNode;
            head.llink = head;
            head.rlink = head;
            size++;
            return;
        }

        DNode<T> lastNode = getLastNode();
        newNode.llink = lastNode;
        newNode.rlink = head;
        head.llink = newNode;
        head = newNode;
        lastNode.rlink = head;
        size++;
    }

    @Override
    public void add(T data) {
        DNode<T> newNode = new DNode<>(data);

        if (isEmpty()) {
            head = newNode;
            head.llink = head;
            head.rlink = head;
            size++;
            return;
        }

        DNode<T> lastNode = getLastNode();
        lastNode.rlink = newNode;
        newNode.llink = lastNode;
        newNode.rlink = head;
        head.llink = newNode;
        size++;
    }

    @Override
    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        DNode<T> newNode = new DNode<>(data);
        DNode<T> nextNode = search(index);
        DNode<T> preNode = nextNode.llink;

        preNode.rlink = newNode;
        newNode.llink = preNode;
        newNode.rlink = nextNode;
        nextNode.llink = newNode;
        size++;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (head.rlink == head) {
            head.llink = null;
            head.rlink = null;
            head = null;
            size--;
            return;
        }

        DNode<T> firstNode = head;
        DNode<T> lastNode = getLastNode();

        head = head.rlink;
        head.llink = lastNode;
        lastNode.rlink = head;
        firstNode.llink = null;
        firstNode.rlink = null;
        size--;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (head.rlink == head) {
            head.llink = null;
            head.rlink = null;
            head = null;
            size--;
            return;
        }

        DNode<T> lastNode = getLastNode();
        DNode<T> preNode = lastNode.llink;

        preNode.rlink = head;
        head.llink = preNode;
        lastNode.llink = null;
        lastNode.rlink = null;
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

        DNode<T> deleteNode = search(index);
        DNode<T> preNode = deleteNode.llink;
        DNode<T> nextNode = deleteNode.rlink;

        preNode.rlink = nextNode;
        nextNode.llink = preNode;
        deleteNode.llink = null;
        deleteNode.rlink = null;
        size--;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        DNode<T> pre;
        DNode<T> temp = head;
        while (temp.rlink != head) {
            pre = temp;
            temp = temp.rlink;
            pre.llink = null;
            pre.rlink = null;
        }
        temp.llink = null;
        temp.rlink = null;
        head = null;
        size = 0;
    }

    /*
     * receive the index and return the node's data
     */
    @Override
    public T get(int index) {
        DNode<T> node = search(index);
        return node.getData();
    }

    /*
     * receive the index and return the node
     */
    private DNode<T> search(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Out of index.");
        }

        int idx = 0;
        DNode<T> temp = head;
        while (idx != index) {
            idx++;
            temp = temp.rlink;
        }
        return temp;
    }

    /*
     * find the last node
     */
    private DNode<T> getLastNode() {
        DNode<T> temp = head;
        while (temp.rlink != head) {
            temp = temp.rlink;
        }
        return temp;
    }
}