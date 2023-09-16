package com.example.DataStructureAndAlgorithms.linear.queue;

import java.util.Stack;

public class QueueWithStack {

    Stack<Integer> stack;
    Stack<Integer> reversedStack;

    public QueueWithStack() {
        stack = new Stack<>();
        reversedStack = new Stack<>();
    }

    public void enqueue(Integer number) {
        stack.push(number);
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("البتاعة فاضية يا اعمى");
        }

        while (!stack.empty()) {
            reversedStack.push(stack.pop());
        }

        reversedStack.pop();

        while (!reversedStack.empty()) {
            stack.push(reversedStack.pop());
        }
    }

    public Boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
