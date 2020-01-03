package com.jbn.study;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * BinarySearchTreeTest
 */
public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @Before
    public void init() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void allTest() {
        int[] nums = { 5, 3, 6, 8, 4, 2 };
        for (int i : nums) {
            bst.add(i);
        }
        bst.preOrder();
        System.out.println("------");
        bst.preOrderByStack();
        System.out.println("------");
        System.out.println(bst);
        bst.inOrder();
        System.out.println("------");
        bst.postOrder();
        System.out.println("------");
        bst.levelOrder();

    }

    @Test
    public void removeMinTest() {
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                throw new IllegalArgumentException("Test error!");
            }
        }

        System.out.println("Test passed!");
    }

    @Test
    public void removeTest() {
        int[] nums = { 5, 3, 6, 8, 4, 2 };
        for (int i : nums) {
            bst.add(i);
        }
        bst.remove(6);
        bst.remove(4);
        System.out.println(bst);

    }

}