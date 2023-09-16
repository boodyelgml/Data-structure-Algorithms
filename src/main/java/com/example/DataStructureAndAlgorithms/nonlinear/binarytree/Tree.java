package com.example.DataStructureAndAlgorithms.nonlinear.binarytree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Tree {
    public Node root;

    public Tree() {
        this.root = new Node();
    }

    public String insert(Integer value) {

        if (this.root.getValue() == null) {
            this.root.setValue(value);
            return this.root.getValue().toString();
        }
        Node currentNode = this.root;

        while (true) {
            if (currentNode.getValue() < value) {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new Node(value));
                    return currentNode.getRight().getValue().toString();
                } else {
                    currentNode = currentNode.getRight();
                }
            } else {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new Node(value));
                    return currentNode.getLeft().getValue().toString();
                } else {
                    currentNode = currentNode.getLeft();
                }
            }
        }
    }


    public Boolean find(Integer integer) {
        if (this.root.getValue() == null) {
            return false;
        }
        Node currentNode = this.root;

        if (currentNode.getValue().equals(integer)) {
            return true;
        }

        while (currentNode.getRight() != null || currentNode.getLeft() != null) {
            if (integer > currentNode.getValue()) {
                currentNode = currentNode.getRight();
                if (Objects.equals(currentNode.getValue(), integer)) {
                    return true;
                }
            } else {
                currentNode = currentNode.getLeft();
                if (Objects.equals(currentNode.getValue(), integer)) {
                    return true;
                }
            }
        }

        return false;
    }

    List<Integer> VALUES = new ArrayList<>();

    public void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        this.VALUES.add(node.getValue());
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());
    }

    public void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        preOrderTraverse(node.getLeft());
        this.VALUES.add(node.getValue());
        preOrderTraverse(node.getRight());
    }


    public void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());
        this.VALUES.add(node.getValue());
    }

    public void levelOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        this.VALUES.add(node.getValue());
    }


    public Integer height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public Integer minValue(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(minValue(node.getLeft()), minValue(node.getRight())), node.getValue());
    }

    public Integer orderedTreeminValue(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getValue();
    }


    public Boolean isEquals(Tree tree1, Tree tree2) {
        return Objects.equals(tree1.root.getValue(), tree2.root.getValue())
                && isEquals(tree1.root.getLeft(), tree2.root.getLeft())
                && isEquals(tree1.root.getRight(), tree2.root.getRight());
    }

    public Boolean isEquals(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            return isEquals(node1.getLeft(), node2.getLeft()) &&
                    isEquals(node1.getRight(), node2.getRight()) &&
                    Objects.equals(node1.getValue(), node2.getValue());
        } else {
            return false;
        }
    }

    public Boolean isBinarySearchTree(Node node) {

        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return true;
        }

        Node left = node.getLeft();
        Node right = node.getRight();

        isBinarySearchTree(left);
        isBinarySearchTree(right);

        if (left == null) {
            return node.getValue() < right.getValue();
        } else if (right == null) {
            return left.getValue() < node.getValue();
        }

        return left.getValue() < node.getValue() && node.getValue() < right.getValue();
    }


    public void levelOrderTraversal() {
        var treeHeight = height(this.getRoot());
        for (int i = 0; i < treeHeight; i++) {
            distanceFromRoot(this.getRoot(), i);
        }
    }

    public void distanceFromRoot(Node node, Integer distance) {

        if (node == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(node.getValue());
            return;
        }

        distanceFromRoot(node.getLeft(), distance - 1);
        distanceFromRoot(node.getRight(), distance - 1);

    }


}
