package com.avinash.graph.minimum.spanning.tree;

public class Vertex {
    private final String name;
    private Node node;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return name;
    }
}
