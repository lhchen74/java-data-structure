package com.jbn.study;

import java.util.ArrayList;

import com.jbn.study.utils.FileOperation;

import org.junit.Test;

/**
 * LinkedListMapTest
 */
public class LinkedListMapTest {

    private String filename = "D:/study/java/datastructure/src/test/java/com/jbn/study/ATaleofTwoCities.txt";

    @Test
    public void allTest() {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFileWordToArray(filename, words);
        System.out.println("ArrayList size: " + words.size());

        Map<String, Integer> map = new LinkedListMap<>();
        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("LinkedListMap size: " + map.getSize());
        System.out.println("city: " + map.get("city"));
    }
}