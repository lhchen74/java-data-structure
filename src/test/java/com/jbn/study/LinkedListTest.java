package com.jbn.study;

import org.junit.Test;

/**
 * LinkedListTest
 */
public class LinkedListTest {
    @Test
    public void test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 2333);
        System.out.println(linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

    }

    @Test
    public void removeElementTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.addFirst(6);
        for (int i = 0; i < 5; i++) {
            linkedList.removeElement(i);
            System.out.println(linkedList);
        }
    }
}