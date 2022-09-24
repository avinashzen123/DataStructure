package com.avinash.minimum.spanning.tree;

public class Node {
    private final int id;
    Node parentNode;
    private int rank;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
