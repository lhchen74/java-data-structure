package com.jbn.study;

import org.junit.Test;

/**
 * SegmentTreeTest
 */
public class SegmentTreeTest {
    @Test
    public void test() {
        Integer[] arr = { -2, 0, 3, -5, 2, -1 };
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(1, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}