package com.example.DataStructureAndAlgorithms.nonlinear.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    public Integer value;
    public Node left;
    public Node right;
    
    public Node(Integer value) {
        this.value = value;
    }
}
