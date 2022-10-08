package com.avinash.minimum.spanning.tree;


public class Edge implements Comparable<Edge> {
    private final Vertex startVertex, endVertex;
    private final double weight;

    public Edge(Vertex startVertex, Vertex endVertex, double weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(weight, o.weight);
    }

    @Override
    public String toString() {
        return startVertex +
                "-" + endVertex +
                ", ";
    }
}
