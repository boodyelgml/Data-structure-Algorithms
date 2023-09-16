package com.example.DataStructureAndAlgorithms.nonlinear.heap;

public class Heap {

    int[] items = new int[10];
    int size;

    public void insert(int value) throws IllegalAccessException {
        if (isFull()) {
            throw new IllegalAccessException();
        }
        items[size++] = value;
        int index = size - 1;
        bubbleup(index);
    }

    private void swap(int index, int parentIndex) {
        int temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        items[0] = items[size - 1];
        size--;

        int index = 0;

        while (index <= size && !isValidParent(index)) {
            bubbleDown(items[index], largerChild(index));
            index = largerChild(index);
        }
        return items[0];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int largerChild(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return items[leftChildIndex(index)];
        }
        return Math.max(items[rightChildIndex(index)], items[leftChildIndex(index)]);
    }

    private void bubbleDown(int parent, int largerChild) {
        var temp = items[parent];
        items[parent] = items[largerChild];
        items[largerChild] = temp;
    }

    private void bubbleup(int index) {
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        if (!hasRightChild(index)) {
            return items[index] >= items[leftChildIndex(index)];
        }
        return items[index] >= items[leftChildIndex(index)] && items[index] >= items[rightChildIndex(rightChildIndex(index))];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isFull() {
        return size > items.length;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    // ISSUE HERE
    public static void heapSort(int[] numbers) throws IllegalAccessException {
        Heap heap = new Heap();
        for (int n : numbers) {
            heap.insert(n);
        }
        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }

    // TODO
    // implement priority queue class using heaps
}
