package com.jbn.study;

import org.junit.Test;

public class LinkedListStatckTest {
    @Test
    public void testAll() {
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        int popRes = stack.pop();
        System.out.println(popRes);
        System.out.println(stack);
        int peekRes = stack.peek();
        System.out.println(peekRes);
        System.out.println(stack);
    }
}