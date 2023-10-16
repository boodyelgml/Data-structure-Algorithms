package com.example.DataStructureAndAlgorithms.nonlinear.AVLtree;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AVLtree {
    private AVLNode root;

    public void insert(Integer value) {
        this.root = insert(root, value);
    }
    private AVLNode insert(AVLNode root, Integer value) {
        if (root == null) {
            return new AVLNode(value);
        }

        if (value < root.getValue()) {
            root.leftChild = insert(root.getLeftChild(), value);
        } else {
            root.rightChild = insert(root.getRightChild(), value);
        }

        root.height = height(root);
        root.balanceFactor = height(root.getLeftChild()) - height(root.getRightChild());

        balance(root);
        return root;
    }
    private void balance(AVLNode root) {

        if (root.balanceFactor > 1) {
            root.heavyDirection = "left";
            if (root.getLeftChild().getBalanceFactor() > 0) {
                rotateRight(root);
            } else if (root.getLeftChild().getBalanceFactor() < 0) {
                rotateLeft(root.leftChild);
                rotateRight(root);
            }
        } else if (root.balanceFactor < -1) {
            root.heavyDirection = "right";
            if (root.getRightChild().getBalanceFactor() > 0) {
                rotateRight(root.rightChild);
                rotateLeft(root);
            } else if (root.getRightChild().getBalanceFactor() < 0) {
                rotateLeft(root);
            }
        }
    }
    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        height(root);
        height(newRoot);

        return newRoot;
    }
    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        height(root);
        height(newRoot);

        return newRoot;
    }
    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
    }


}
