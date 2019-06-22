package com.avinash.skip.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList<T extends Comparable<T>> {
    private final List<Node<T>> headers = new ArrayList<>();
    private final int levels;
    private final Random random = new Random();
    public int numberOfComparision = 0;

    public SkipList(int levels) {
        this.levels = levels;
        for (int i = 0; i < this.levels; i++) {
            this.headers.add(null);
        }
    }

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>(5);
        for (int i = 0; i < 98; i += 2) {
            skipList.insert(i);
        }
        skipList.insert(11);
        skipList.display();
        System.out.println(skipList.find(11));
        System.out.println("Number of comparision " + skipList.numberOfComparision);
    }

    public void insert(T data) {
        if (this.headers.get(0) == null) {
            createHeader(data);
        } else if (this.headers.get(0).compareTo(data) > 0) {
            updateHeader(data);
        } else {
            final int level = randomLevel();
            Node<T> nextLevel = null;
            for (int i = this.headers.size() - 1; i >= level; i--) {
                Node<T> node = this.headers.get(i);
                Node<T> prevNode = null;
                while (node != null) {
                    prevNode = node;
                    if (node.compareTo(data) == 0) {
                        break;
                    } else if (node.compareTo(data) < 0) {
                        if (node.getNext() != null && node.getNext().compareTo(data) < 0) {
                            node = node.getNext();
                        } else {
                            break;
                        }
                    }
                }
                final Node<T> newNode = new Node<>(data);
                newNode.setNext(prevNode.getNext());
                prevNode.setNext(newNode);
                newNode.setNextLevel(nextLevel);
                nextLevel = newNode;
            }
        }
    }

    public Node<T> find(T data) {
        return find(data, this.headers.get(0));
    }

    private Node<T> find(T data, Node<T> node) {
        Node prevNode = null;
        while (node != null && node.compareTo(data) <= 0) {
            prevNode = node;
            node = node.getNext();
        }
        if(prevNode.getNextLevel() != null) {
            return find(data, prevNode.getNextLevel());
        } else {
            if(prevNode.compareTo(data) == 0) {
                return prevNode;
            } else {
                while (prevNode != null) {
                    if(prevNode.compareTo(data) == 0) {
                        return prevNode;
                    } else {
                        prevNode = prevNode.getNext();
                    }
                }
            }
        }
        return prevNode;
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

    private void updateHeader(T data) {
        Node<T> levelDown = null;
        for (int i = this.headers.size() - 1; i >= 0; i--) {
            final Node<T> newNode = new Node<>(data);
            newNode.setNextLevel(levelDown);
            newNode.setNext(this.headers.get(i));
            levelDown = newNode;
            this.headers.set(i, newNode);
        }
    }

    private void createHeader(T data) {
        Node<T> levelDown = null;
        for (int i = this.levels - 1; i >= 0; i--) {
            final Node<T> newNode = new Node<>(data);
            newNode.setNextLevel(levelDown);
            levelDown = newNode;
            this.headers.set(i, newNode);
        }
    }

    private int randomLevel() {
        final int nextInt = this.random.nextInt(this.levels);
        return nextInt >= 0 ? nextInt : randomLevel();
    }
}
