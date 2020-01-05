package com.jbn.study;

import java.util.ArrayList;

/**
 * BSTMap
 */
public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public int height;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);
//        if (Math.abs(balanceFactor) > 1) {
//            System.out.println("unbalanced: " + balanceFactor);
//        }

        // Balance maintain

        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >=0) {
            return rightRotate(node);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i).compareTo(keys.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);

    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     *  y right rotate, return the root x
     *         y                                           x
     *       /  \                                        /   \
     *      x    T4       right rotate (y)              z     y
     *     /  \          ------------------->          /  \   /  \
     *    z    T3                                     T1  T2  T3  T4
     *   /  \
     *  T1  T2
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // right rotate
        x.right = y;
        y.left = T3;

        // update height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     *  y left rotate, return the root x
     *         y                                           x
     *       /  \                                        /   \
     *      T1    x       right rotate (y)              y      z
     *          /  \      ------------------->        /  \    /  \
     *        T2    z                                T1  T2  T3  T4
     *             /  \
     *            T3  T4
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // left rotate
        x.left = y;
        y.right = T2;

        // update height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    public K minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        Node mNode = minimum(root);
        return mNode.key;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public K removeMin() {
        K key = minimum();
        removeMin(root);
        return key;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        } else {
            root = remove(root, key);
            return node.value;
        }
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        Node retNode;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                Node successorNode = minimum(node.right);
                successorNode.left = node.left;
                // successorNode.right = removeMin(node.right);
                successorNode.right = remove(node.right, successorNode.key);
                node.left = node.right = null;
                retNode = successorNode;
            }
        }

        if (retNode == null) {
            return null;
        }

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        int balanceFactor = getBalanceFactor(retNode);

        // Balance maintain

        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >=0) {
            return rightRotate(retNode);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exists!");
        }
        node.value = newValue;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }
}