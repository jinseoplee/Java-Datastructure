package com.ljs.collection.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void init() {
        stack = new LinkedStack<>();
    }

    @AfterEach
    public void cleanup() {
        stack = null;
    }

    @Test
    public void popAndPeekTest() {
        // given
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // when
        int data = stack.pop();
        int data2 = stack.peek();

        // then
        assertEquals(data, 4);
        assertEquals(data2, 3);
    }

    @Test
    public void deleteTest() {
        // given
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // when
        stack.delete();

        // then
        int data = stack.peek();
        assertEquals(data, 3);
    }

    @Test
    public void clearTest() {
        // given
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // when
        stack.clear();

        // then
        assertTrue(stack.isEmpty());
    }
}
