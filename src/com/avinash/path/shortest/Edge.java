package com.avinash.path.shortest;

public class Edge implements Comparable<Edge> {
    private final Vertex startVertex, endVertex;
    private final Double weight;

    public Edge(Vertex startVertex, Vertex endVertex, Double weight) {
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

    public Double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return 0;
    }
}
