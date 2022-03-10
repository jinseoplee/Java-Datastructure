package com.ljs.collection.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayCircularQueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    public void init() {
        queue = new ArrayCircularQueue<>(5);
    }

    @AfterEach
    public void cleanup() {
        queue = null;
    }

    @Test
    public void enQueueAndDeQueueTest() {
        // given
        for (int i = 1; i <= 4; i++) {
            queue.enQueue(i);
        }

        for (int i = 0; i < 4; i++) {
            queue.deQueue();
        }

        for (int i = 5; i <= 7; i++) {
            queue.enQueue(i);
        }

        // when
        int data = queue.deQueue();

        // then
        assertEquals(data, 5);
    }

    @Test
    public void deleteTest(){
        // given
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        // when
        for(int i=0; i<4; i++){
            queue.delete();
        }

        // then
        assertTrue(queue.isEmpty());
    }

}