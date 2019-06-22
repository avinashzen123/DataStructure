package com.avinash.skip.list;

import org.jetbrains.annotations.NotNull;

public class Node<T extends Comparable<T>> implements Comparable<T> {

    private final T data;

    private Node<T> nextLevel;

    private Node<T> next;

    public Node(T data) {
        this.data = data;

    }

    public Node(T data, Node<T> nextLevel, Node<T> next) {
        this.data = data;
        this.nextLevel = nextLevel;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Node<T> nextLevel) {
        this.nextLevel = nextLevel;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public int compareTo(@NotNull T o) {
        return data.compareTo(o);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
