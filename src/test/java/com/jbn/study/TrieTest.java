package com.jbn.study;

import org.junit.Test;

/**
 * TrieTest
 */
public class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.add("cat");
        trie.add("deer");
        trie.add("dog");
        System.out.println(trie.search("d..r"));
        System.out.println(trie.search(".at"));
    }
}