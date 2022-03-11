package com.ljs.collection.deque;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    public void init() {
        deque = new Deque<>();
    }

    @AfterEach
    public void cleanup() {
        deque = null;
    }

    @Test
    public void Given_Data_When_InsertFront_DeleteFront_Then_Stack() {
        // given
        int data = 15;
        int data2 = 21;
        int data3 = 31;

        // when
        deque.insertFront(data);
        deque.insertFront(data2);
        deque.insertFront(data3);

        int result = deque.deleteFront();

        // then
        assertEquals(result, 31);
    }

    @Test
    public void Given_Data_When_InsertRear_DeleteRear_Then_Stack() {
        // given
        int data = 13;
        int data2 = 31;
        int data3 = 52;

        // when
        deque.insertRear(data);
        deque.insertRear(data2);
        deque.insertRear(data3);

        int result = deque.deleteRear();

        // then
        assertEquals(result, 52);
    }

    @Test
    public void Given_Data_When_InsertRear_DeleteFront_Then_Queue() {
        // given
        int data = 1;
        int data2 = 2;
        int data3 = 3;

        // when
        deque.insertRear(data);
        deque.insertRear(data2);
        deque.insertRear(data3);

        int result = deque.deleteFront();

        // then
        assertEquals(result, 1);
    }

    @Test
    public void Given_Data_When_DeleteFront_DeleteRear_Then_IsEmpty() {
        // given
        deque.insertRear(1);
        deque.insertRear(2);
        deque.insertRear(3);

        // when
        deque.removeFront();
        deque.removeRear();
        deque.removeRear();

        // then
        assertTrue(deque.isEmpty());
    }

}