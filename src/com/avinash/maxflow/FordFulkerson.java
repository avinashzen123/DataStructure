package com.avinash.maxflow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FordFulkerson {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double maxFlow;

    public FordFulkerson(FlowNetwork flowNetwork, Vertex source, Vertex sink) {
        while (hasAugmentedPath(flowNetwork, source, sink)) {
            double minFlow = Double.POSITIVE_INFINITY;
            for (Vertex vertex = sink; vertex != source; vertex = otherVertex(vertex, this.edgeTo[vertex.getId()])) {
                minFlow = Math.min(minFlow, this.residualCapacity(this.edgeTo[vertex.getId()], vertex));
            }
            for (Vertex vertex = sink; vertex != source; vertex = otherVertex(vertex, this.edgeTo[vertex.getId()])) {
                this.setResidualFlow(vertex, this.edgeTo[vertex.getId()], minFlow);
            }
            this.maxFlow += minFlow;
        }
    }

    /**
    Maximum flow is: 8.0
    Vertices in the min cut set: 
    0 - 1 - 2 -
    **/
    public static void main(String[] args) {
        FlowNetwork flowNetwork = new FlowNetwork(4);

        Vertex vertex0 = new Vertex(0, "s");
        Vertex vertex1 = new Vertex(1, "A");
        Vertex vertex2 = new Vertex(2, "B");
        Vertex vertex3 = new Vertex(3, "t");

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);

        flowNetwork.addEdge(new Edge(vertex0, vertex1, 4));
        flowNetwork.addEdge(new Edge(vertex0, vertex2, 5));

        flowNetwork.addEdge(new Edge(vertex1, vertex3, 7));

        flowNetwork.addEdge(new Edge(vertex2, vertex1, 4));
        flowNetwork.addEdge(new Edge(vertex2, vertex3, 1));

        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, vertex0, vertex3);

        System.out.println("Maximum flow is: " + fordFulkerson.getMaxFlow());

        // print min-cut
        System.out.println("Vertices in the min cut set: ");
        for (int v = 0; v < vertexList.size(); v++) {
            if (fordFulkerson.isInCut(v))
                System.out.print(vertexList.get(v) + " - ");
        }
    }

    private boolean hasAugmentedPath(FlowNetwork flowNetwork, Vertex source, Vertex sink) {
        this.marked = new boolean[flowNetwork.getNumberOfVertices()];
        this.edgeTo = new Edge[flowNetwork.getNumberOfVertices()];
        this.marked[source.getId()] = true;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty() && !this.marked[sink.getId()]) {
            final Vertex vertex = queue.remove();
            flowNetwork.getAdjacencies().get(vertex.getId()).forEach(edge -> {
                Vertex otherVertex = otherVertex(vertex, edge);
                double residualCapacity = residualCapacity(edge, otherVertex);
                if (residualCapacity > 0 && !this.marked[otherVertex.getId()]) {
                    this.marked[otherVertex.getId()] = true;
                    this.edgeTo[otherVertex.getId()] = edge;
                    queue.add(otherVertex);
                }
            });
        }
        return this.marked[sink.getId()];
    }

    private double residualCapacity(Edge edge, Vertex otherVertex) {
        return edge.getStartVertex() == otherVertex ? edge.getFlow() : edge.getCapacity() - edge.getFlow();
    }

    private Vertex otherVertex(Vertex vertex, Edge edge) {
        return edge.getStartVertex() == vertex ? edge.getEndVertex() : edge.getStartVertex();
    }

    private void setResidualFlow(Vertex vertex, Edge edge, double delta) {
        if (edge.getStartVertex() == vertex) {
            edge.setFlow(edge.getFlow() - delta);
        } else {
            edge.setFlow(edge.getFlow() + delta);
        }
    }

    public boolean isInCut(int id) {
        return this.marked[id];
    }

    public double getMaxFlow() {
        return maxFlow;
    }
}
