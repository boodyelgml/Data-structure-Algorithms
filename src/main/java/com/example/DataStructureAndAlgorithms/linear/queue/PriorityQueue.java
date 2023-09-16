package com.example.DataStructureAndAlgorithms.linear.queue;

import java.util.Arrays;

public class PriorityQueue {
    int[] items;
    int count;

    public PriorityQueue(int size) {
        this.items = new int[size];
    }

    public void enqueue(int item) {
        if (count == items.length) {
            throw new IllegalArgumentException();
        }

        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        items[i + 1] = item;
        count++;
    }

    public int remove() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        return items[--count];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
