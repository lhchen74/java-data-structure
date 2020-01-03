package com.jbn.study;

import org.junit.Test;

/**
 * ArrayTest
 */
public class ArrayTest {

    @Test
    public void addTest() {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(10, 100);
        array.addFirst(100);
        System.out.println(array);
    }

    @Test
    public void removeTest() {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.removeFirst();
        array.removeLast();
        array.removeElement(6);
        array.remove(1);
        System.out.println(array);
    }

    @Test
    public void genericTest() {
        Array<Student> students = new Array<>();
        students.addLast(new Student("babb", 88));
        students.addLast(new Student("alice", 90));
        students.addLast(new Student("mike", 100));
        System.out.println(students);
    }

    @Test
    public void resizeTest() {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        for (int i = 0; i < 5; i++) {
            array.removeLast();
        }
        System.out.println(array);
    }

}