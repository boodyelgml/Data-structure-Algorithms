package com.example.DataStructureAndAlgorithms.linear.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedBrackets {
    private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');
    Stack<Character> characters = new Stack<>();

    public Boolean isBalanced(String str) {

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isLeftBracket(ch)) {
                characters.push(ch);
            }

            if (isRightBracket(ch)) {
                if (characters.empty()) return false;
                Character topLeft = characters.pop();
                if (!isBracketsMatch(ch, topLeft)) {
                    return false;
                }
            }
        }

        return characters.isEmpty();

    }

    private Boolean isLeftBracket(char c) {
        return leftBrackets.contains(c);
    }

    private Boolean isRightBracket(char c) {
        return rightBrackets.contains(c);
    }

    private Boolean isBracketsMatch(char right, char left) {
        return rightBrackets.indexOf(right) == leftBrackets.indexOf(left);
    }
}
