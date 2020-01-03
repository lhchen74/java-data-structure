package com.jbn.study;

import java.time.Instant;
import java.util.ArrayList;

import com.jbn.study.utils.FileOperation;

import org.junit.Before;
import org.junit.Test;

/**
 * SetPerformanceTest
 */
public class SetPerformanceTest {

    private Set<String> bstSet;
    private Set<String> linkedListSet;
    private Set<String> trieSet;
    private String filename = "D:/study/java/datastructure/src/test/java/com/jbn/study/ATaleofTwoCities.txt";

    @Before
    public void init() {
        bstSet = new BSTSet<>();
        linkedListSet = new LinkedListSet<>();
        trieSet = new TrieSet();
    }

    public double calcTime(Set<String> set) {
        long startTime = Instant.now().toEpochMilli();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFileWordToArray(filename, words);
        System.out.println("ArrayList size: " + words.size());

        for (String word : words) {
            set.add(word);
        }

        System.out.println("Set size: " + set.getSize());
        for (String word : words) {
            set.contains(word);
        }

        long endTime = Instant.now().toEpochMilli();

        return (endTime - startTime) / 1000.0;
    }

    @Test
    public void testPerformance() {
        double linkedListCost = calcTime(linkedListSet);
        System.out.println("LinkedListSet cost: " + linkedListCost + " s");

        double bstSetCost = calcTime(bstSet);
        System.out.println("BSTSet cost: " + bstSetCost + " s");

        double trieSetCost = calcTime(trieSet);
        System.out.println("TrieSet cost: " + trieSetCost + " s");
    }
}