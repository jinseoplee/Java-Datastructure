package com.ljs.collection.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularLinkedListTest {

    private List<Integer> list;

    @BeforeEach
    public void init() {
        list = new CircularLinkedList<>();
    }

    @AfterEach
    public void cleanup() {
        list = null;
    }

    @Test
    public void addTest() {
        // given
        list.addFirst(0);
        list.add(2);
        list.add(3);
        list.add(1, 1);

        // then
        assertEquals(list.get(0), 0);
        assertEquals(list.get(1), 1);
        assertEquals(list.get(2), 2);
        assertEquals(list.get(3), 3);
    }

    @Test
    public void removeTest() {
        // given
        list.addFirst(0);
        list.add(2);
        list.add(3);
        list.add(1, 1);

        // when
        list.remove(1);
        list.removeFirst();
        list.remove();

        // then
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), 2);
    }

    @Test
    public void getTest() {
        // given
        list.addFirst(0);
        list.add(2);
        list.add(3);
        list.add(1, 1);

        // when
        int data = list.get(2);

        // then
        assertEquals(data, 2);
    }

    @Test
    public void clearTest() {
        // given
        list.addFirst(0);
        list.add(2);
        list.add(3);
        list.add(1, 1);

        // when
        list.clear();

        // then
        assertTrue(list.isEmpty());
    }

}
