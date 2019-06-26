package com.avinash.skip.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface TestCondition {
    boolean test(Comparable comparable, Comparable comparable1);
}

@FunctionalInterface
interface HeaderOperation {
    void apply(int i, Node node);
}
public class SkipList1<T extends Comparable<T>> {
    private final List<Node<T>> headers = new ArrayList<>();
    private final int levels;
    private final Random random = new Random();
    private final TestCondition testGreater = (Comparable info, Comparable info1) -> info.compareTo(info1) > 0;
    private final TestCondition testGreaterEqual = (Comparable info1, Comparable info2) -> info1.compareTo(info2) >= 0;
    private final HeaderOperation addHeader = (int i, Node node) -> this.headers.add(node);
    private final HeaderOperation updateHeader = (int i, Node node) -> {
        node.setNext(this.headers.get(i));
        this.headers.set(i, node);
    };
    public int numberOfComparision = 0;

    public SkipList1(int levels) {
        this.levels = levels;
    }

    public static void main(String[] args) {
        SkipList1<Integer> skipList = new SkipList1<>(10);
        for (int i = 0; i < 100; i += 2) {
            skipList.insert(i);
        }
        skipList.insert(3);
        skipList.display();
        skipList.numberOfComparision = 0;
        System.out.println(skipList.findNode(92) + "  " + skipList.numberOfComparision);
    }

    private void insert(T data) {
        final int randomLevel = randomLevel();
        if (this.headers.size() == 0) {
            headerOperation(data, addHeader);
        } else if (data.compareTo(this.headers.get(randomLevel).getData()) < 0) {
            headerOperation(data, updateHeader);
        } else {
            Node<T> prevNode = findPrevNode(data, this.headers.get(randomLevel), testGreater);
            Node<T> node = createNode(data, prevNode);
            prevNode = prevNode.getNextLevel();
            Node levelUp = node;
            while (prevNode != null) {
                prevNode = findPrevNode(data, prevNode, testGreater);
                node = createNode(data, prevNode);
                prevNode = prevNode.getNextLevel();
                if (levelUp != null) {
                    levelUp.setNextLevel(node);
                }
                levelUp = node;
            }
        }
    }

    private Node<T> createNode(T data, Node<T> prevNode) {
        Node<T> node = new Node<>(data);
        node.setNext(prevNode.getNext());
        prevNode.setNext(node);
        return node;
    }

    public Node<T> findNode(T data) {
        return findNode(data, this.headers.get(0));
    }

    private Node<T> findNode(T data, Node<T> node) {
        final Node<T> prevNode = findPrevNode(data, node, testGreaterEqual);
        return prevNode.getNextLevel() == null ? prevNode : findNode(data, prevNode.getNextLevel());
    }

    private Node<T> findPrevNode(T data, Node<T> node, TestCondition predicate) {
        Node<T> prevNode = null;
        Node<T> currentNode = node;
        while (currentNode != null && predicate.test(data, currentNode.getData())) {
            this.numberOfComparision++;
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return prevNode;
    }

    private void headerOperation(T data, HeaderOperation headerOperation) {
        Node<T> levelUp = null;
        for (int i = 0; i < this.levels; i++) {
            final Node<T> node = new Node<>(data);
            if (levelUp != null) {
                levelUp.setNextLevel(node);
            }
            headerOperation.apply(i, node);
            levelUp = node;
        }
    }

    private int randomLevel() {
        final int nextInt = this.random.nextInt(this.levels);
        return nextInt > 0 ? nextInt : randomLevel();
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
}
