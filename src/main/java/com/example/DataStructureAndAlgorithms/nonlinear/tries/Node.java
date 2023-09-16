package com.example.DataStructureAndAlgorithms.nonlinear.tries;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Node {
    char value;
    HashMap<Character, Node> children = new HashMap<>();
    boolean isLastChar;

    public Node(char value) {
        this.value = value;
    }

}
