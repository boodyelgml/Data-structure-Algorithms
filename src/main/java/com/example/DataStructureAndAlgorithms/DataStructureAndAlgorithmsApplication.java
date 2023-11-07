package com.example.DataStructureAndAlgorithms;

import com.example.DataStructureAndAlgorithms.algorithms.searching.Searching;
import com.example.DataStructureAndAlgorithms.algorithms.stringmanipulation.StringManipulation;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DataStructureAndAlgorithmsApplication {
    public static void main(String[] args) throws IllegalAccessException {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        Searching searching = new Searching();
        System.out.println(searching.exponentialSearch(ints, 3));
    }
}
