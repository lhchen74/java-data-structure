package com.jbn.study;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * LeetcodeTest
 */
public class LeetcodeTest {

    private Leetcode leetcode;

    @Before
    public void init() {
        leetcode = new Leetcode();
    }

    @Test
    public void testIsParenthesisMatching() {
        assertEquals(true, leetcode.isParenthesisMatching("{[()]}"));
        assertEquals(false, leetcode.isParenthesisMatching("{{[()]}"));
        assertEquals(false, leetcode.isParenthesisMatching("{[()}"));
        assertEquals(false, leetcode.isParenthesisMatching("()}"));
    }

    @Test
    public void testRemoveLinkedList() {
        int[] nums = { 1, 2, 6, 3, 4, 5, 6 };
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = leetcode.removeLinkedListElements(head, 6);
        System.out.println(res);
        ListNode res2 = leetcode.removeLinkedListElementsByDummyHead(head, 6);
        System.out.println(res2);
        ListNode res3 = leetcode.removeLinkedListElementsByRecursive(head, 6);
        System.out.println(res3);
    }

    @Test
    public void intersectionOfArrayTest() {
        int[] nums1 = new int[] { 1, 2, 2, 3 };
        int[] nums2 = new int[] { 2, 2 };
        int[] res = leetcode.intersectionOfArray(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }

    @Test
    public void intersectionOfArrayTwoTest() {
        int[] nums1 = new int[] { 1, 2, 2, 3 };
        int[] nums2 = new int[] { 2, 2 };
        int[] res = leetcode.intersectionOfArrayTwo(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }

    @Test
    public void topKFrequentTest() {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3 };
        List<Integer> list = leetcode.topKFrequent(nums, 2);
        System.out.println(list);
    }

    @Test
    public void topKFrequentByJavaInnerPriorityQueueTest() {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3 };
        List<Integer> list = leetcode.topKFrequentByJavaInnerPriorityQueue(nums, 2);
        System.out.println(list);
    }

    @Test
    public void sumRangeTest() {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        Leetcode.NumArray numArray = new Leetcode().new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(1, 5));
        System.out.println(numArray.sumRange(0, 5));
        numArray.update(0, 0);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(1, 5));
        System.out.println(numArray.sumRange(0, 5));

        Leetcode.NumArraySegmentTree numArray2 = new Leetcode().new NumArraySegmentTree(nums);
        System.out.println(numArray2.sumRange(0, 2));
        System.out.println(numArray2.sumRange(2, 5));
        System.out.println(numArray2.sumRange(1, 5));
        System.out.println(numArray2.sumRange(0, 5));
        numArray2.update(0, 0);
        System.out.println(numArray2.sumRange(0, 2));
        System.out.println(numArray2.sumRange(2, 5));
        System.out.println(numArray2.sumRange(1, 5));
        System.out.println(numArray2.sumRange(0, 5));
    }

    @Test
    public void mapSumTest() {
        Leetcode.MapSum mapSum = new Leetcode().new MapSum();
        mapSum.add("apple", 2);
        mapSum.add("app", 3);
        System.out.println(mapSum.sum("app"));
    }
}
