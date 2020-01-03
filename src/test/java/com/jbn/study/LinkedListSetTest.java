package com.jbn.study;

import java.util.ArrayList;

import com.jbn.study.utils.FileOperation;

import org.junit.Test;

/**
 * LinkedListSetTest
 */
public class LinkedListSetTest {
    private String filename = "D:/study/java/datastructure/src/test/java/com/jbn/study/ATaleofTwoCities.txt";

    @Test
    public void allTest() {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFileWordToArray(filename, words);
        // System.out.println(words);
        System.out.println("ArrayList size: " + words.size());
        Set<String> setWords = new LinkedListSet<>();
        for (String word : words) {
            setWords.add(word);
        }
        System.out.println("BSTSet size: " + setWords.getSize());
    }
}