package com.example.DataStructureAndAlgorithms.linear.stack;

import java.util.Arrays;

public class StackWithArray {
    int[] stack;
    Integer count = 0;

    public StackWithArray(Integer size) {
        stack = new int[size];
    }

    public void push(int number){
        stack[count++] = number;
    }

    public void pop(){
        stack[--count] = 0;
    }

    public void peek(){
        System.out.println(stack[count-1]);
    }

    public void print(){
        int[] newArr = Arrays.copyOfRange(stack,0,count);
        System.out.println(Arrays.toString(newArr));
    }
}
