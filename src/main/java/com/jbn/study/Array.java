package com.jbn.study;

/**
 * Array
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        // Can not use as this, Because E will Type Erasure to Object;
        // new Integer[capacity] => new Object[capacity]
        // new String [capacity] => new Object[capacity]
        // this.data = new E[capacity];
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * According index location add element e
     * 
     * Time complexity O(n/2) = O(n)
     * 
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
            // throw new IllegalArgumentException("Add failed. Array is full.");
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // O(n)
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // O(1)
    // Amortized time complexity
    // n + 1 times addLast, n + 1 addLast + 1 resize (n)
    // Amortized time complexity = (n + n + 1) / n
    public void addLast(E e) {
        add(size, e);
    }

    // O(n)
    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            // if (data[i] == e) {
            // return true;
            // }
            if (data[i].equals(e)) { // e is object not basic data-type, use equal rather than ==
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            // if (data[i] == e) {
            // return i;
            // }
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <= size.");
        }
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // make loitering object collected by GCC
        size--;

        // if (size == data.length / 2) {
        // resize(size);
        // }

        // Avoid complex oscillation, addLast(e), removeLast() ...
        // Lazy: when size == data.length / 4 (not / 2), shrinkage capacity
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(size);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Illegal index i: " + i + " or j: " + j);
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

}