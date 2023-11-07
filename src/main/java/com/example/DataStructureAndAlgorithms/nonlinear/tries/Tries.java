package com.example.DataStructureAndAlgorithms.nonlinear.tries;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tries {
    Node root = new Node(' ');
    public void insert(String word) throws IllegalAccessException {
        if (word == null) {
            throw new IllegalAccessException();
        }
        Node current = root;
        for (var ch : word.toCharArray()) {
            Node node = current.getChildren().get(ch);
            if (node == null) {
                current.getChildren().put(ch, new Node(ch));
            }
            current = current.getChildren().get(ch);
        }
        current.setLastChar(true);
    }
    public boolean search(String word) throws IllegalAccessException {
        if (word == null) {
            throw new IllegalAccessException();
        }
        Node current = root;
        for (var ch : word.toCharArray()) {
            Node node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = current.getChildren().get(ch);
        }
        return current.isLastChar();
    }
    public void traverse() {
        traverse(root);
    }
    private void traverse(Node root) {
        System.out.println(root.getValue());

        Node[] nodes = root.getChildren().values().toArray(new Node[0]);
        for (Node node : nodes) {
            traverse(node);
        }
    }
    public void remove(String word) {
        remove(root, word, 0);
    }
    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.setLastChar(false);
            return;
        }
        char ch = word.charAt(index);
        Node node = root.getChildren().get(ch);
        if (node == null) {
            return;
        }
        remove(node, word, index + 1);
        if (node.isLastChar && node.getChildren().size() == 0) {
            root.getChildren().remove(node);
        }
    }
    public List<String> autoComplete(String word) throws IllegalAccessException {
        if (word == null) {
            throw new IllegalAccessException();
        }
        List<String> words = new ArrayList<>();
        Node lastNode = lastNode(root, word);

        findWords(lastNode, word, words);
        return words;
    }
    private void findWords(Node root, String word, List<String> words) {
        if (root.isLastChar) {
            words.add(word);
        }

        for (Node child : root.getChildren().values().toArray(new Node[0])) {
            findWords(child, word + child.getValue(), words);
        }
    }
    private Node lastNode(Node root, String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            Node node = current.getChildren().get(ch);
            if (node != null) {
                current = node;
            }
        }
        return current;
    }

}