package com.jbn.study;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

/**
 * MaxHeapTest
 */
public class MaxHeapTest {
    @Test
    public void test() {
        int n = 100000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(maxHeap.extractMax());
        }

        for (int i = 1; i < n; i++) {
            if (list.get(i - 1) < list.get(i)) {
                throw new IllegalArgumentException("Test error!");
            }
        }

        System.out.println("Test MaxHeap completed!");
    }

    public double calcTime(Integer[] nums, boolean isHeapify) {
        long startTime = Instant.now().toEpochMilli();

        MaxHeap<Integer> maxHeap;
        if (isHeapify == true) {
            maxHeap = new MaxHeap<>(nums);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer num : nums) {
                maxHeap.add(num);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(maxHeap.extractMax());
        }

        for (int i = 1; i < nums.length; i++) {
            if (list.get(i - 1) < list.get(i)) {
                throw new IllegalArgumentException("Test error!");
            }
        }

        System.out.println("Test MaxHeap completed!");

        long endTime = Instant.now().toEpochMilli();

        return (endTime - startTime) / 1000.0;
    }

    @Test
    public void heapifyTest() {

        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double heapifyCost = calcTime(testData, true);
        System.out.println("HeapifyCost cost: " + heapifyCost + " s");

        double noneHeapifyCost = calcTime(testData, false);
        System.out.println("NoneHeapifyCost cost: " + noneHeapifyCost + " s");
    }
}