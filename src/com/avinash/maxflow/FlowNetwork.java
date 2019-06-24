package com.avinash.maxflow;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private final int numberOfVertices;
    private List<List<Edge>> adjacencies;

    public FlowNetwork(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adjacencies = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            this.adjacencies.add(new ArrayList<>());
        }
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public List<List<Edge>> getAdjacencies() {
        return adjacencies;
    }

    public void addEdge(Edge edge) {
        this.adjacencies.get(edge.getStartVertex().getId()).add(edge);
        this.adjacencies.get(edge.getEndVertex().getId()).add(edge);
    }

}
