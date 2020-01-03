package com.jbn.study;

import org.junit.Test;

/**
 * LinkedListQueueTest
 */
public class LinkedListQueueTest {
    @Test
    public void testAll() {
        Queue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);

            if (i % 3 == 2) {
                queue.dequeue();
            }

            System.out.println(queue);
        }

    }
}