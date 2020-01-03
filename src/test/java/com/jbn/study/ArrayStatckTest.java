package com.jbn.study;

import org.junit.Test;

/**
 * ArrayStatckTest
 */
public class ArrayStatckTest {
    @Test
    public void testAll() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 4; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        int popRes = arrayStack.pop();
        System.out.println(popRes);
        System.out.println(arrayStack);
        int peekRes = arrayStack.peek();
        System.out.println(peekRes);
        System.out.println(arrayStack);
    }
}