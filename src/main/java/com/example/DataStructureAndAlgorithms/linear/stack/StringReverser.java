package com.example.DataStructureAndAlgorithms.linear.stack;

import java.util.Stack;

public class StringReverser {

    public StringReverser(String str) {
        StringBuilder reversed = new StringBuilder();
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            strings.push(String.valueOf(str.charAt(i)));
        }

        for (int i = 0; i < str.length(); i++) {
            reversed.append(strings.pop());
        }
        System.out.println(reversed);
    }
}
