package com.jbn.study;

/**
 * MaxHeap
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // heapify
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // To a given index, find it's parent index relative to dynamic array;
    // index start at zero.
    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 has not parent index");
        }
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);
        return ret;
    }

    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);

            // getMax of index leftChild and rightChild
            // (j + 1) < data.getSize() estimate index is has rightChild
            if ((j + 1) < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j = j + 1;
            }

            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(index, j);

            index = j;
        }
    }

    public E replaceMax(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}