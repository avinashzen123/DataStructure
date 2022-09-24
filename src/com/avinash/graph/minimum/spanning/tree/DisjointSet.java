package com.avinash.graph.minimum.spanning.tree;


import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    private List<Node> rootNodes = new ArrayList<>();

    public DisjointSet(List<Vertex> vertices) {
        vertices.forEach(this::makeSet);
    }

    private void makeSet(Vertex vertex) {
        final Node node = new Node(this.rootNodes.size());
        vertex.setNode(node);
        this.rootNodes.add(node);
    }

    public int find(Vertex vertex) {
        Node currentNode = vertex.getNode();
        while (currentNode.getParentNode() != null) {
            currentNode = currentNode.getParentNode();
        }
        final Node rootNode = currentNode;
        currentNode = vertex.getNode();
        while (rootNode != currentNode) {
            Node parentNode = currentNode.getParentNode();
            currentNode.setParentNode(rootNode);
            currentNode = parentNode;
        }
        return rootNode.getId();
    }

    public void union(Vertex vertex1, Vertex vertex2) {
        final int index1 = find(vertex1);
        final int index2 = find(vertex2);
        if (index1 == index2) {
            return;
        }
        if (vertex1.getNode().getRank() < vertex2.getNode().getRank()) {
            vertex1.getNode().setParentNode(vertex2.getNode());
        } else if (vertex1.getNode().getRank() > vertex2.getNode().getRank()) {
            vertex2.getNode().setParentNode(vertex1.getNode());
        } else {
            vertex1.getNode().setParentNode(vertex2.getNode());
            vertex2.getNode().setRank(vertex2.getNode().getRank() + 1);
        }
    }
}
