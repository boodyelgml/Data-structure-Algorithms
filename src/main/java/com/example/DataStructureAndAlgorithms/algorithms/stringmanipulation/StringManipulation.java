package com.example.DataStructureAndAlgorithms.algorithms.stringmanipulation;

import java.util.*;

public class StringManipulation {

    public void splitSentence(String sentence) {
        Stack<String> stack = new Stack<String>();
        String[] words = sentence.split(" ");
        StringBuilder newSentence = new StringBuilder();

        for (String word : words) {
            stack.push(word);
        }

        while (!stack.isEmpty()) {
            newSentence.append(" ").append(stack.pop());
        }
        newSentence.deleteCharAt(0);
        System.out.println(newSentence);
    }

    public void revert(String word) throws IllegalAccessException {
        if (word == null) {
            throw new IllegalAccessException();
        }
        StringBuilder string = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            string.append(word.toCharArray()[i]);
        }
        System.out.println(string);
    }

    public boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        return (str1.length() == str2.length() && (str1 + str1).contains(str2));
    }

    public void vowelsCount(String word) {
        String vowels = "AEOUI";
        word = word.toUpperCase();
        char[] array = word.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (vowels.contains(String.valueOf(array[i]))) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void removeDuplicates(String word) {
        Set<Character> characters = new HashSet<>();
        StringBuilder string = new StringBuilder();
        for (Character c :
                word.toCharArray()) {
            if (!characters.contains(c)) {
                characters.add(c);
                string.append(c);
            }
            System.out.println(string);
        }
    }

    public void mostRepeatedCharacter(String word) {
        HashMap<Character, Integer> integerHashMap = new HashMap<>();
        for (Character c : word.toCharArray()) {
            if (integerHashMap.containsKey(c)) {
                integerHashMap.replace(c, integerHashMap.get(c) + 1);
            } else {
                integerHashMap.put(c, 1);
            }
        }

        Character mostRepeatedChar = null;
        int maximumRepeatedCount = 0;

        for (Character c : word.toCharArray()) {
            if (integerHashMap.get(c) > maximumRepeatedCount) {
                mostRepeatedChar = c;
                maximumRepeatedCount = integerHashMap.get(c);
            }
        }

        System.out.println(mostRepeatedChar);
    }

    public void capitalize(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder capitalizedSentence = new StringBuilder();
        for (String word : words) {
            word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length()).toLowerCase();
            capitalizedSentence.append(word).append(" ");
        }
        capitalizedSentence.substring(capitalizedSentence.length() - 1, capitalizedSentence.length());
        System.out.println(capitalizedSentence);

    }

    public boolean isAnagram(String str1, String str2) {
        char[] characters1 = str1.toLowerCase().toCharArray();
        char[] characters2 = str2.toLowerCase().toCharArray();

        Arrays.sort(characters1);
        Arrays.sort(characters2);

        if (characters1 == characters2) {
            return true;
        }
        return false;
    }

    public boolean isAnagram2(String str1, String str2) {

        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        for (Character c : str1.toLowerCase().toCharArray()) {
            if (!str2.contains(c.toString().toLowerCase())) {
                return false;
            }
        }

        for (Character c : str2.toLowerCase().toCharArray()) {
            if (!str1.contains(c.toString().toLowerCase())) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String word) {
        StringBuilder builder = new StringBuilder(word.toLowerCase());
        builder.reverse();
        return builder.toString().equals(word.toLowerCase());
    }
}
