package com.example.DataStructureAndAlgorithms.linear.linkedlist;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void addLast(T item) {
        Node<T> tNode = new Node<>(item);
        if (isEmpty())
            head = tail = tNode;
        else {
            tail.setNext(tNode);
            tail = tNode;
        }
        size++;
    }

    public void addFirst(T item) {
        Node<T> tnode = new Node<>(item);
        if (isEmpty()) {
            head = tail = tnode;
        } else {
            tnode.setNext(head);
            head = tnode;
        }
        size++;
    }

    public int indexOf(T item) {
        Integer index = 0;
        Node<T> current = head;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Linked List is empty");
        }
        while (current != null) {
            if (current.getValue() == item) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean isContains(T item) {
        return indexOf(item) != -1;
    }

    private Boolean isEmpty() {
        return head == null;
    }

    public void removeFirst() {
        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> second = head.getNext();
            head.setNext(null);
            head.setValue(null);
            head = second;
        }
        size--;
    }

    public void removeLast() {
        Node<T> current = head;
        Node beforeLast = new Node<>();
        if (head == tail) {
            head = tail = null;
        } else {
            while (current.getNext() != null) {
                beforeLast = current;
                current = current.getNext();
            }
            beforeLast.setNext(null);
            tail = beforeLast;
        }
        size--;
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        var index = 0;
        Node<T> current = head;
        while (current != null) {
            arr[index] = (int) current.getValue();
            current = current.getNext();
            index++;
        }
        return arr;
    }

    public void reverse() {

        Node<T> current = head.getNext();
        Node<T> previous = head;
        head.setNext(null);

        tail = head;
        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        head = previous;

    }

    public int findKthFromEnd(int k) {
        Node<T> a = head;
        Node<T> b = head;

        for (int i = 0; i < k - 1; i++) {
            b = b.getNext();
        }
        while (b.getNext() != null) {
            a = a.getNext();
            b = b.getNext();
        }
        return (int) a.getValue();

    }

    public void findMiddle() {
        Node<T> a = head;
        Node<T> b = tail;
        String middle;
        while (a.getNext() != null) {
            b = b.getNext().getNext();
            a = a.getNext();
        }

        if (size % 2 == 1) {
            middle = (String) a.getValue();
        } else {
            middle = a.getValue() + "," + a.getNext().getValue();
        }
        System.out.println(middle);
    }
}
