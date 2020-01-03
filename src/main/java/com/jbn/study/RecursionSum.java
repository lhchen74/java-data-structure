package com.jbn.study;

/**
 * RecursionSum
 */
public class RecursionSum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * Calc arr[i...n) sum
     * 
     * @param arr
     * @param i
     * @return
     */
    private static int sum(int[] arr, int i) {
        if (arr.length == i) {
            return 0;
        }
        return arr[i] + sum(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(sum(nums));
    }
}