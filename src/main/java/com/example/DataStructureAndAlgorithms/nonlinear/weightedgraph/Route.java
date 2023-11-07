package com.example.DataStructureAndAlgorithms.nonlinear.weightedgraph;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Route {
    public City from;
    public City to;
    public int weight;

    @Override
    public String toString() {
        return from.getLabel() + "->" + to.getLabel() + " = " + weight;
    }
}
