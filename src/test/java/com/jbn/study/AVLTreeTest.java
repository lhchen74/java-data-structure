package com.jbn.study;

import com.jbn.study.utils.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

/**
 * BSTMapTest
 */
public class AVLTreeTest {

    private String filename = "/Users/jbn/Documents/study/java/java-data-structure/src/test/java/com/jbn/study/ATaleofTwoCities.txt";

    @Test
    public void allTest() {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFileWordToArray(filename, words);
        System.out.println("ArrayList size: " + words.size());

        AVLTree<String, Integer> map = new AVLTree<>();
        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("AVLTree size: " + map.getSize());
        System.out.println("city: " + map.get("city"));
        System.out.println("is BST: " + map.isBST());
        System.out.println("is Balanced: " + map.isBalance());

//        String word = words.get(0);
//        map.remove(word);
//        System.out.println("is Balanced: " + map.isBalance());
        for (String word : words) {
            map.remove(word);
            if (!map.isBalance()) {
                System.out.println("Remove test error.");
            }
        }
    }
}