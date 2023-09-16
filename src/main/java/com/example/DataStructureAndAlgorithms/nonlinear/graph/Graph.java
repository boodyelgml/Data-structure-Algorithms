package com.example.DataStructureAndAlgorithms.nonlinear.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> vertices = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        vertices.putIfAbsent(node, new ArrayList<>());
    }

    public void removeNode(String label) throws IllegalAccessException {
        Node node = nodes.get(label);
        if (node == null) {
            throw new IllegalAccessException();
        }

        for (Node obj : vertices.keySet()) {
            vertices.get(obj).remove(node);
        }

        vertices.remove(node);
        nodes.remove(node);
    }

    public void addEdge(String from, String to) throws IllegalAccessException {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null) {
            throw new IllegalAccessException();
        }

        if (toNode == null) {
            throw new IllegalAccessException();
        }

        vertices.get(fromNode).add(toNode);
    }

    public void removeEdge(String from, String to) throws IllegalAccessException {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null) {
            throw new IllegalAccessException();
        }

        if (toNode == null) {
            throw new IllegalAccessException();
        }

        vertices.get(fromNode).remove(toNode);
    }

    public void print() {
        for (var x : vertices.keySet()) {
            if (vertices.get(x).size() > 0)
                System.out.println(x + " is connected to " + vertices.get(x));
        }
    }


//    private void traverse(String node) {
//        if (!nodes.containsKey(node)) {
//            return;
//        }
//        traverse(node, new HashSet<>());
//    }
//
//    private void traverse(String node, HashSet set) {
//
//    }
}