package com.example.DataStructureAndAlgorithms.nonlinear.graph;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Node {
    private String label;
    @Override
    public String toString() {
        return label;
    }
}
