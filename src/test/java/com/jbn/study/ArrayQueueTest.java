package com.jbn.study;

import org.junit.Test;

/**
 * ArrayStatckTest
 */
public class ArrayQueueTest {
    @Test
    public void testAll() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
            }

            System.out.println(arrayQueue);
        }

    }
}