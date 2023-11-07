package com.example.DataStructureAndAlgorithms.nonlinear.weightedgraph;

import lombok.Data;

import java.util.*;

@Data
public class WeightedGraph {
    Map<String, City> cities = new HashMap<>();

    public City addCity(String name) {
        City current = new City(name);
        cities.putIfAbsent(name, current);
        return current;
    }

    public void addRoute(String from, String to, int weight) {
        City fromCity = cities.get(from);
        City toCity = cities.get(from);
        fromCity.addRoute(toCity, weight);
        toCity.addRoute(fromCity, weight);
    }

    public void print() {
        for (var x : cities.values()) {
            for (var y : x.getRoutes()) {
                System.out.println(y.toString());
            }
        }
    }

    private class CityEntry {
        private City city;
        private int distance;

        public CityEntry(City city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

    public int getShortestPath(City from, City to) {
        PriorityQueue<CityEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.distance));
        Map<City, Integer> distances = new HashMap<>();
        Map<City, City> prevCity = new HashMap<>();

        for (City city : cities.values()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        City fromCity = cities.get(from);
        distances.replace(fromCity, 0);

        queue.add(new CityEntry(fromCity, 0));

        Set<City> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            City currentCity = queue.remove().city;
            visited.add(currentCity);

            for (var route : currentCity.getRoutes()) {
                if (visited.contains(route.getTo())) {
                    continue;
                }
                int newDistance = distances.get(currentCity) + route.getWeight();
                if (newDistance < distances.get(route)) {
                    distances.replace(route.getTo(), newDistance);
                    queue.add(new CityEntry(route.getTo(), newDistance));
                }
            }
        }

        return distances.get(cities.get(to));
    }
}