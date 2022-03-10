package com.ljs.collection.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    public void init(){
        queue = new ArrayQueue<>(5);
    }

    @AfterEach
    public void cleanup(){
        queue = null;
    }

    @Test
    public void enQueueTest(){
        // given
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        // when
        int data = queue.peek();

        // then
        assertEquals(data, 1);
    }

    @Test
    public void deQueueTest(){
        // given
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        // when
        int data = queue.deQueue();
        int data2 = queue.deQueue();

        // then
        assertEquals(data, 1);
        assertEquals(data2, 2);
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