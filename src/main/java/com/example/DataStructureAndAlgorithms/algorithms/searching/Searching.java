package com.example.DataStructureAndAlgorithms.algorithms.searching;

import java.util.Arrays;

public class Searching {

    public int binarySearch(int[] arr, int target) {
        return binarySearchIter(arr, target, 0, arr.length - 1);
    }
    private int binarySearchIter(int[] arr, int target, int left, int right) {

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target == arr[middle]) {
                return middle;
            }

            if (target < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
    private int binarySearchRec(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;

        int middle = (left + right) / 2;

        if (target == arr[middle]) {
            return middle;
        }

        if (target < arr[middle]) {
            return binarySearchRec(arr, target, left, middle - 1);
        } else {
            return binarySearchRec(arr, target, middle + 1, right);
        }
    }
    public void linearSearch(int[] arr, int target) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == target) {
                System.out.println(j);
                break;
            }
            System.out.println(-1);
        }
    }
    public int ternarySearch(int[] arr, int target) {
        return ternarySearch(arr, target, 0, arr.length - 1);
    }
    private int ternarySearch(int[] arr, int target, int left, int right) {
        int partitionSize = right - left;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (target == arr[mid1]) {
            return mid1;
        }

        if (target == arr[mid2]) {
            return mid2;
        }

        if (target < arr[mid1]) {
            return ternarySearch(arr, target, left, mid1 - 1);
        } else if (target > arr[mid2]) {
            return ternarySearch(arr, target, mid2 + 1, right);
        } else {
            return ternarySearch(arr, target, mid1 + 1, mid2 - 1);
        }
    }
    public int jumpSearch(int[] arr, int target) {
        int blockSize = (int) Math.sqrt(arr.length);
        int start = 0;

        int next = blockSize;

        while (start < arr.length && target < arr[blockSize - 1]) {
            start = next;
            next += blockSize;
            if (next > arr.length) {
                next = arr.length;
            }
        }

        for (int i = start; i < next; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }

        int end = 1;
        while (end < arr.length && arr[end] <= target) {
            end *= 2;
        }

        int start = end / 2;
        return binarySearch(Arrays.copyOfRange(arr, start, end), target);
    }
}
