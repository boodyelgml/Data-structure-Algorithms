package com.example.DataStructureAndAlgorithms.linear.array;

/*
 * In Java, we have 2 dynamic arrays classes
 * 1- vectors : grow by 100% - synchronized
 * 2- arrayList : grow by 50% - not synchronized
 * */

/*
 * ArrayList.toArray(); --> this will convert the ArrayList object to native array datatype
 * */

import java.util.ArrayList;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int element) {
        if (items.length == count) {
            int[] newItems = new int[items.length * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count] = element;
        count++;

    }

    public void removeAt(int index) {
        if (index >= 0 && index < count) {
            for (int i = index; i < count; i++) {
                items[i] = items[i + 1];
            }
            count--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int indexOf(int element) {
        for (int i = 0; i < count; i++) {
            if (items[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void intersect(int[] intersectArray) {
        ArrayList<Integer> commonItems = new ArrayList<>();
        for (int item : intersectArray) {
            for (int i = 0; i < count; i++) {
                if (items[i] == item) {
                    commonItems.add(item);
                }
            }
        }
        System.out.println(commonItems);
    }

    public void reverse() {
        Array reversed = new Array(count);
        for (int i = count - 1; i >= 0; i--) {
            reversed.insert(items[i]);
        }
        reversed.print();
    }

    public void max() {
        int largestNumber = 0;
        for (int i = 0; i < count; i++) {
            if (items[i] > largestNumber) {
                largestNumber = items[i];
            }
        }
        System.out.println(largestNumber);
    }

    public void insertAt(int item, int index) {

        int[] newItems = new int[items.length * 2];
        boolean inserted = false;
        for (int i = 0; i < count+1; i++) {
            if (i == index) {
                newItems[i] = item;
                inserted = true;
            } else if (!inserted) {
                newItems[i] = items[i];
            } else if (inserted) {
                newItems[i] = items[i - 1];
            }
        }
        items = newItems;
        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

}
