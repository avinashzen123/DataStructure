package com.avinash.skip.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList<T extends Comparable<T>> {
    private final int levels;
    private Random random;
    private List<Node<T>> headers;

    public SkipList(int levels) {
        this.levels = levels;
        this.headers = new ArrayList<>();
        this.random = new Random();
        for (int i = this.levels - 1; i >= 0; i--) {
            this.headers.add(null);
        }
    }

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>(5);
        for (int i = 0; i < 90; i += 2) {
            skipList.insert(i);
        }
        skipList.insert(19);
        skipList.display();
        System.out.println(skipList.find(21));
    }

    public void insert(T data) {
        final int level = randomLevel();
        if (this.headers.get(level) == null) {
            Node<T> prevLevel = null;
            for (int i = this.levels - 1; i >= 0; i--) {
                this.headers.set(i, new Node<>(data, prevLevel, null));
                prevLevel = this.headers.get(i);
            }
        } else if (this.headers.get(level).compareTo(data) > 0) {
            Node<T> prevLevel = null;
            for (int i = this.levels - 1; i >= 0; i--) {
                this.headers.set(i, new Node<>(data, prevLevel, this.headers.get(i)));
                prevLevel = this.headers.get(i);
            }
        } else {
            Node<T> levelUpNode = null;
            for (int i = level; i < this.levels; i++) {
                final Node<T> nearNode = findNearNode(data, this.headers.get(i), null);
                if (nearNode.compareTo(data) == 0) {
                    throw new RuntimeException("Element already exist");
                } else {
                    final Node<T> newNode = new Node<>(data, null, nearNode.getNext());
                    nearNode.setNext(newNode);
                    if (levelUpNode != null) {
                        levelUpNode.setNextLevel(newNode);
                    }
                    levelUpNode = newNode;
                }
            }
        }
    }

    private Node<T> find(T data) {
        Node<T> node = this.headers.get(0);
        while (node.getNextLevel() != null) {
            final Node<T> nearNode = findNearNode(data, node, null);
            node = nearNode.getNextLevel();
        }
        return node;
    }

    private Node<T> findNearNode(T data, Node<T> node, Node<T> prevNode) {
        if (node.compareTo(data) == 0) {
            return node;
        } else if (node.compareTo(data) < 0) {
            if (node.getNext() == null) {
                return node;
            } else {
                return findNearNode(data, node.getNext(), node);
            }
        } else {
            return prevNode;
        }
    }

    public void display() {
        for (int i = 0; i < this.levels; i++) {
            Node<T> node = this.headers.get(i);
            while (node != null) {
                System.out.print(node + ", ");
                node = node.getNext();
            }
            System.out.println(" ");
        }
    }

    private int randomLevel() {
        final int nextInt = this.random.nextInt(this.levels);
        return nextInt >= 0 ? nextInt : randomLevel();
    }
}
