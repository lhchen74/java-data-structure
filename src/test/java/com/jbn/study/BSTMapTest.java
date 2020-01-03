package com.jbn.study;

import java.util.ArrayList;

import com.jbn.study.utils.FileOperation;

import org.junit.Test;

/**
 * BSTMapTest
 */
public class BSTMapTest {

    private String filename = "D:/study/java/datastructure/src/test/java/com/jbn/study/ATaleofTwoCities.txt";

    @Test
    public void allTest() {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFileWordToArray(filename, words);
        System.out.println("ArrayList size: " + words.size());

        Map<String, Integer> map = new BSTMap<>();
        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("BSTMap size: " + map.getSize());
        System.out.println("city: " + map.get("city"));
    }
}