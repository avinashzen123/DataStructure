package com.avinash.search.ternary.tree;

import org.jetbrains.annotations.NotNull;

public class Node<T extends Comparable<T>> implements Comparable<Character> {
    private final Character character;
    private Node leftNode, rightNode, middleNode;
    private T data;

    public Node(Character character) {
        this.character = character;
    }

    public Node(Character character, T data) {
        this.character = character;
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getMiddleNode() {
        return middleNode;
    }

    public void setMiddleNode(Node middleNode) {
        this.middleNode = middleNode;
    }

    public Character getCharacter() {
        return character;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(@NotNull Character o) {
        return character.compareTo(o);
    }
}
