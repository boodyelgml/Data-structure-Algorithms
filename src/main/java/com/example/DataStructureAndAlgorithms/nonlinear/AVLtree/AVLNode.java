package com.example.DataStructureAndAlgorithms.nonlinear.AVLtree;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AVLNode {
    private Integer value;
    AVLNode leftChild;
    AVLNode rightChild;
    String heavyDirection;
    Integer balanceFactor;
    Integer height;

    public AVLNode(Integer value) {
        this.value = value;
    }
}
