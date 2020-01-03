package com.jbn.study;

import java.time.Instant;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * QueuePerformanceTest
 */
public class QueuePerformanceTest {

    private Queue<Integer> arrayQueue;
    private Queue<Integer> loopQueue;
    private Queue<Integer> linkedListQueue;
    private int opCount;

    @Before
    public void init() {
        arrayQueue = new ArrayQueue<>();
        loopQueue = new LoopQueue<>();
        linkedListQueue = new LinkedListQueue<>();
        opCount = 10000;
    }

    public double calcTime(Queue<Integer> queue, int opCount) {
        long startTime = Instant.now().toEpochMilli();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = Instant.now().toEpochMilli();

        return (endTime - startTime) / 1000.0;
    }

    @Test
    public void testPerformance() {
        double arrayCost = calcTime(arrayQueue, opCount);
        System.out.println("ArrayQueue cost: " + arrayCost + " s");

        double loopCost = calcTime(loopQueue, opCount);
        System.out.println("LoopQueue cost: " + loopCost + " s");

        double linkedListCost = calcTime(linkedListQueue, opCount);
        System.out.println("LinkedListQueue cost: " + linkedListCost + " s");
    }
}