package com.example.DataStructureAndAlgorithms.nonlinear.graph;

import java.util.*;

public class Graph {
    private final Map<String, City> cities = new HashMap<>();
    private final Map<City, Set<City>> routes = new HashMap<>();
    public void addCity(String cityName) {
        City city = new City(cityName);
        cities.putIfAbsent(cityName, city);
        routes.putIfAbsent(city, new HashSet<>());
    }
    public void addRoute(String from, String to) throws IllegalAccessException {
        City fromCity = cities.get(from);
        City toCity = cities.get(to);
        if (fromCity == null || toCity == null) {
            throw new IllegalAccessException();
        }

        Set<City> cityRoutes = routes.get(fromCity);

        cityRoutes.add(toCity);
    }
    public void removeCity(String cityName) throws IllegalAccessException {
        City city = cities.get(cityName);
        if (city == null) {
            throw new IllegalAccessException();
        }

        for (City node : routes.keySet()) {
            routes.get(node).remove(city);
        }
        cities.remove(cityName);
        routes.remove(city);
    }
    public void print(String cityName) {
        StringBuilder toPrint = new StringBuilder("city " + cityName + " connected with ");
        City city = cities.get(cityName);
        if (city == null) {
            throw new IllegalStateException();
        }

        Set<City> cityRoutes = routes.get(city);
        for (City c : cityRoutes) {
            toPrint.append(", " + c.getLabel()).toString();
        }
        System.out.println(toPrint);
    }
}
