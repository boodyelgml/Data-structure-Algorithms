package com.example.DataStructureAndAlgorithms;

import com.example.DataStructureAndAlgorithms.nonlinear.graph.Graph;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DataStructureAndAlgorithmsApplication {

    public static void main(String[] args) throws IllegalAccessException {
        Graph graph = new Graph();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.print();
    }

}
