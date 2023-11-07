package com.example.DataStructureAndAlgorithms.nonlinear.weightedgraph;

import com.example.DataStructureAndAlgorithms.nonlinear.tries.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class City {
    public String label;
    public Set<Route> routes;

    public City(String label) {
        this.label = label;
        this.routes = new HashSet<>();
    }

    public void addRoute(City to, int weight) {
        routes.add(new Route(this, to, weight));
        to.getRoutes().add(new Route(to, this, weight));
    }

    @Override
    public String toString() {
        return label;
    }



}
