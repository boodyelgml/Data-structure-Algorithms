package com.example.DataStructureAndAlgorithms;

import com.example.DataStructureAndAlgorithms.nonlinear.graph.Graph;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DataStructureAndAlgorithmsApplication {

    public static void main(String[] args) throws IllegalAccessException {
        Graph graph = new Graph();
        graph.addCity("a");
        graph.addCity("b");
        graph.addCity("c");
        graph.addRoute("a", "b");
        graph.addRoute("a", "c");
        graph.print("a");
    }

}
