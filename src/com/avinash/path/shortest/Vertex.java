package com.avinash.path.shortest;

public class Vertex implements Comparable<Vertex> {
    private final String name;
    private Vertex prevVertex;
    private Double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Vertex getPrevVertex() {
        return prevVertex;
    }

    public void setPrevVertex(Vertex prevVertex) {
        this.prevVertex = prevVertex;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name + " " + distance;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(distance, o.getDistance());
    }
}
