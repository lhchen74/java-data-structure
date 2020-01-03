package com.jbn.study;

import java.util.TreeMap;

/**
 * Trie
 */
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.next.get(c) == null) {
                curNode.next.put(c, new Node());
            }
            curNode = curNode.next.get(c);
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
            size++;
        }
    }


    public boolean contains(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curNode.next.get(c) == null) {
                return false;
            }
            curNode = curNode.next.get(c);
        }
        return curNode.isWord;
    }


    public boolean isPrefix(String prefix) {
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curNode.next.get(c) == null) {
                return false;
            }
            curNode = curNode.next.get(c);
        }
        return true;
    }

    // c.t . represent any one character
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }        

        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar: node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}