package com.jbn.study;

import org.junit.Test;

/**
 * LoopQueueTest
 */
public class LoopQueueTest {
    @Test
    public void testAll() {
        Queue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }

        }

    }
}