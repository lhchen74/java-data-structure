package com.jbn.study;

/**
 * TrieSet
 */
public class TrieSet implements Set<String>{

    private Trie trie;

    public TrieSet() {
        trie = new Trie();
    }

    @Override
    public void add(String e) {
       trie.add(e);
    }

    @Override
    public void remove(String e) {
        
    }

    @Override
    public boolean contains(String e) {
        return trie.contains(e);
    }

    @Override
    public int getSize() {
       return trie.size();
    }

    @Override
    public boolean isEmpty() {
        return trie.size() == 0;
    }
}