package com.example.DataStructureAndAlgorithms.algorithms.sorting;

import java.util.Arrays;

public class Sorting {
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = 0; j < array.length; j++) {
                if(array[minIndex] < array[j]){
                    int temp = array[minIndex];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
