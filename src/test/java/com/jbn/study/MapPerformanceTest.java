package com.jbn.study;

import java.time.Instant;
import java.util.ArrayList;

import com.jbn.study.utils.FileOperation;

import org.junit.Before;
import org.junit.Test;

/**
 * MapPerformanceTest
 */
public class MapPerformanceTest {

    private Map<String, Integer> bstMap;
    private Map<String, Integer> linkedListMap;
    private String filename = "D:/study/java/datastructure/src/test/java/com/jbn/study/ATaleofTwoCities.txt";

    @Before
    public void init() {
        bstMap = new BSTMap<>();
        linkedListMap = new LinkedListMap<>();
    }

    public double calcTime(Map<String, Integer> map) {
        long startTime = Instant.now().toEpochMilli();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFileWordToArray(filename, words);
        System.out.println("ArrayList size: " + words.size());

        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("Map size: " + map.getSize());

        long endTime = Instant.now().toEpochMilli();

        return (endTime - startTime) / 1000.0;
    }

    @Test
    public void testPerformance() {
        double linkedListCost = calcTime(linkedListMap);
        System.out.println("LinkedListMap cost: " + linkedListCost + " s");

        double bstMapCost = calcTime(bstMap);
        System.out.println("BSTMap cost: " + bstMapCost + " s");
    }
}