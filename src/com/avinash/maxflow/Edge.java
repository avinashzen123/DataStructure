package com.avinash.maxflow;

public class Edge {
    private final Vertex startVertex, endVertex;
    private double capacity, flow;

    public Edge(Vertex startVertex, Vertex endVertex, double capacity) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.capacity = capacity;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "startVertex=" + startVertex +
                ", endVertex=" + endVertex +
                ", capacity=" + capacity +
                ", flow=" + flow +
                '}';
    }
}
