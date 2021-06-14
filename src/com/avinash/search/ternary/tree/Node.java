package com.avinash.search.ternary.tree;


public class Node<T extends Comparable<T>> implements Comparable<Character> {
    private final Character character;
    private Node<T> leftNode, rightNode, middleNode;
    private T data;

    public Node(Character character) {
        this.character = character;
    }

    public Node(Character character, T data) {
        this.character = character;
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<T> getMiddleNode() {
        return middleNode;
    }

    public void setMiddleNode(Node<T> middleNode) {
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
    public int compareTo(Character o) {
        return character.compareTo(o);
    }
}
