package com.example.DataStructureAndAlgorithms.nonlinear.graph;

import com.example.DataStructureAndAlgorithms.nonlinear.binarytree.Node;

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
            toPrint.append(", ").append(c.getLabel());
        }
        System.out.println(toPrint);
    }
    public void traverseDepthFirst(String root) throws IllegalAccessException {
        Set<City> visited = new HashSet<>();
        City rootCity = cities.get(root);
        traverseDepthFirst(rootCity, visited);
    }
    private void traverseDepthFirst(City root, Set<City> visited) throws IllegalAccessException {
        if (root == null) {
            throw new IllegalAccessException();
        }
        System.out.println(root.getLabel());
        for (City city : routes.get(root)) {
            if (!visited.contains(city)) {
                visited.add(city);
                traverseDepthFirst(city, visited);
            }
        }
    }
    public void traverseDepthFirstIteratively(String root) throws IllegalAccessException {
        if (!cities.containsKey(root)) {
            throw new IllegalAccessException();
        }

        Stack<String> stack = new Stack<>();
        stack.push(root);

        Set<String> visited = new HashSet<>();
        visited.add(root);

        while (!stack.isEmpty()) {
            City current = cities.get(stack.pop());
            System.out.println(current.getLabel());
            visited.add(current.getLabel());

            Set<City> citySet = routes.get(current);
            for (var w : citySet) {
                if (!visited.contains(w.getLabel())) {
                    stack.push(w.getLabel());
                }
            }

        }
    }
    public void traverseBreadthFirstIteratively(String root) throws IllegalAccessException {
        if (!cities.containsKey(root)) {
            throw new IllegalAccessException();
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(root);

        Set<String> visited = new HashSet<>();
        visited.add(root);

        while (!queue.isEmpty()) {
            City current = cities.get(queue.remove());
            System.out.println(current.getLabel());
            visited.add(current.getLabel());

            Set<City> citySet = routes.get(current);
            for (City city : citySet) {
                if (!visited.contains(city.getLabel())) {
                    queue.add(city.getLabel());
                }
            }

        }
    }
    public void topologicalSort() {

        Stack<City> stack = new Stack<>();
        Set<City> visited = new HashSet<>();
        List<String> strings = new ArrayList<>();
        for (String city : cities.keySet()) {
            topologicalSort(cities.get(city), visited, stack);
        }

        while (!stack.isEmpty()) {
            strings.add(stack.pop().getLabel());
        }

        System.out.println(strings);
    }
    private void topologicalSort(City city, Set<City> visited, Stack<City> stack) {
        if (visited.contains(city)) {
            return;
        }

        visited.add(city);

        for (City city1 : routes.get(city)) {
            topologicalSort(city1, visited, stack);
        }

        stack.push(city);
    }
    public boolean hasCycle() {
        Set<City> all = new HashSet<>(cities.values());
        Set<City> visiting = new HashSet<>();
        Set<City> visited = new HashSet<>();

        while (!all.isEmpty()) {
            if (hasCycle(all.iterator().next(), all, visiting, visited))
                return true;
        }
        return false;
    }
    private boolean hasCycle(City city, Set<City> all, Set<City> visiting, Set<City> visited) {
        all.remove(city);
        visiting.add(city);

        for (City neighbour : routes.get(city)) {
            if (visited.contains(city)) {
                continue;
            }

            if (visiting.contains(neighbour)) {
                return true;
            }

            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(city);
        visited.add(city);
        return false;
    }
}
