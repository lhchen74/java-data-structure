package com.jbn.study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Leetcode
 */
public class Leetcode {
    public boolean isParenthesisMatching(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                Character topChar = stack.pop();
                if ((c == ')' && topChar != '(') || (c == ']' && topChar != '[') || (c == '}' && topChar != '{'))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public ListNode removeLinkedListElements(ListNode head, int e) {
        while (head != null && head.e == e) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.e == e) {
                ListNode delNode = prev.next;
                prev.next = delNode.next; // delete node not need prev = prev.next, because prev.next is changed
                delNode.next = null;
            } else {
                prev = prev.next;
            }

        }

        return head;

    }

    public ListNode removeLinkedListElementsByDummyHead(ListNode head, int e) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e == e) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next; // hide dummyHead
    }

    public ListNode removeLinkedListElementsByRecursive(ListNode head, int e) {
        if (head == null) {
            return null;
        }

        head.next = removeLinkedListElementsByRecursive(head.next, e);
        return head.e == e ? head.next : head;
    }

    /**
     * intersectionOfArray
     * 
     * @param nums1 [1, 2, 2, 3]
     * @param nums2 [2, 2]
     * @return [2]
     */
    public int[] intersectionOfArray(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    /**
     * intersectionOfArrayTwo
     * 
     * @param nums1 [1, 2, 2, 3]
     * @param nums2 [2, 2]
     * @return [2, 2]
     */
    public int[] intersectionOfArrayTwo(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    /**
     * Freq
     */
    public class Freq implements Comparable<Freq> {
        public int e;
        public int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq other) {
            // the freq bigger the priority smaller
            if (this.freq < other.freq) {
                return 1;
            } else if (this.freq > other.freq) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (priorityQueue.getSize() < k) {
                priorityQueue.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > priorityQueue.getFront().freq) { // remove the minimum freq
                priorityQueue.dequeue(); // The smallest freq actually has the highest priority
                priorityQueue.enqueue(new Freq(key, map.get(key)));
            }
        }

        java.util.LinkedList<Integer> res = new java.util.LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.dequeue().e);
        }

        return res;
    }

    // Java implements priority queue through the minimum heap
    public List<Integer> topKFrequentByJavaInnerPriorityQueue(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }

        });
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > priorityQueue.peek()) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        java.util.LinkedList<Integer> res = new java.util.LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.remove());
        }

        return res;
    }

    public class NumArray {
        private int[] sum;
        private int[] data;

        public NumArray(int[] nums) {
            data = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        // update is O(n), if use SgmentTree will O(logn)
        public void update(int index, int val) {
            data[index] = val;
            for (int i = index + 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + data[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    public class NumArraySegmentTree {

        private SegmentTree<Integer> segmentTree;

        public NumArraySegmentTree(int[] nums) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            // Cannot infer type arguments for SegmentTree<>
            // segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }

        // update algorithm complexity is O(logn)
        public void update(int index, int val) {
            if (segmentTree == null) {
                throw new IllegalArgumentException("Segment Tree is null");
            }
            segmentTree.set(index, val);
        }

        public int sumRange(int i, int j) {
            if (segmentTree == null) {
                throw new IllegalArgumentException("Segment Tree is null");
            }
            return segmentTree.query(i, j);
        }
    }


    public class MapSum {
        private class Node {
            public int value;
            public TreeMap<Character, Node> next;

            public Node(int value) {
                this.value = value;
                this.next = new TreeMap<>();
            }

            public Node() {
                this(0);
            }
        }

        private Node root;

        public MapSum() {
            this.root = new Node();
        }

        public void add(String word, int value){
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curNode.next.get(c) == null) {
                    curNode.next.put(c, new Node());
                }
                curNode = curNode.next.get(c);
            }
            curNode.value = value;
        }

        public int sum(String prefix) {
            Node curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (curNode.next.get(c) == null) {
                    return 0;
                }
                curNode = curNode.next.get(c);
            }
            return sum(curNode);
        }

        private int sum(Node node) {
            int res = node.value;
            for (char c : node.next.keySet()) {
                res += sum(node.next.get(c));
            }
            return res;
        }


    }

}
