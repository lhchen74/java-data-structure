package com.jbn.study;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

import com.jbn.study.utils.FileOperation;

import org.junit.Before;
import org.junit.Test;

/**
 * MapPerformanceTest
 */
public class MapPerformanceTest {

    private Map<String, Integer> bstMap;
    private Map<String, Integer> linkedListMap;
    private Map<String, Integer> avlTreeMap;
    private String filename = "/Users/jbn/Documents/study/java/java-data-structure/src/test/java/com/jbn/study/ATaleofTwoCities.txt";

    @Before
    public void init() {
        bstMap = new BSTMap<>();
        linkedListMap = new LinkedListMap<>();
        avlTreeMap = new AVLTree<>();
    }

    public double calcTime(Map<String, Integer> map) {
        long startTime = Instant.now().toEpochMilli();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFileWordToArray(filename, words);
        System.out.println("ArrayList size: " + words.size());
        
        Collections.sort(words);

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

        double avlTreeMapCost = calcTime(avlTreeMap);
        System.out.println("AVLTreeMapCost cost: " + avlTreeMapCost + " s");
    }
}