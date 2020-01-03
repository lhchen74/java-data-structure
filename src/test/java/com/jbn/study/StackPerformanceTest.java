package com.jbn.study;

import java.time.Instant;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * StackPerformanceTest
 */
public class StackPerformanceTest {

    private Stack<Integer> arrayStack;
    private Stack<Integer> linkedListStack;
    private int opCount;

    @Before
    public void init() {
        arrayStack = new ArrayStack<>();
        linkedListStack = new LinkedListStack<>();
        opCount = 1000000;
    }

    public double calcTime(Stack<Integer> stack, int opCount) {
        long startTime = Instant.now().toEpochMilli();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = Instant.now().toEpochMilli();

        return (endTime - startTime) / 1000.0;
    }

    @Test
    public void testPerformance() {
        double linkedListCost = calcTime(linkedListStack, opCount);
        System.out.println("LinkedListStack cost: " + linkedListCost + " s");

        double arrayCost = calcTime(arrayStack, opCount);
        System.out.println("ArrayStack cost: " + arrayCost + " s");
    }
}