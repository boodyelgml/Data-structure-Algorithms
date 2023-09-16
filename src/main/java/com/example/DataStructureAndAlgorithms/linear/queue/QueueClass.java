package com.example.DataStructureAndAlgorithms.linear.queue;


import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class QueueClass {
    int[] arr;
    int a;
    int b;
    int count;


    public QueueClass(Integer size) {
        arr = new int[size];
    }

    public void enqueue(Integer number) {
        if (isFull())
            throw new IllegalArgumentException("البتاعة مليانة يا اعمى");

        arr[b] = number;
        b = (b + 1) % arr.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("البتاعة فاضية يا اعمى");

        int item = arr[a];
        arr[a] = 0;
        a = (a + 1) % arr.length;
        count--;
        return item;
    }

    public int peek() {
        return arr[b - 1];
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public Boolean isFull() {
        return count == arr.length;
    }

    public void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (queue.size() != 0) {
            stack.push(queue.remove());
        }
        while (stack.size() != 0) {
            queue.add(stack.pop());
        }
        System.out.println(Arrays.toString(queue.toArray()));
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
