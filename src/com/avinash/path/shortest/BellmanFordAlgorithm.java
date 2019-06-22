package com.avinash.path.shortest;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithm {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public BellmanFordAlgorithm(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public static void main(String[] args) {

        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("1"));
        vertexList.add(new Vertex("2"));
        vertexList.add(new Vertex("3"));
        vertexList.add(new Vertex("4"));
        vertexList.add(new Vertex("5"));

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), (double) 5));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), (double) -4));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), (double) 8));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(0), (double) -2));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(1), (double) -3));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), (double) 9));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(1), (double) 7));
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(0), (double) 6));
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(2), (double) 7));

        BellmanFordAlgorithm bellmannFordAlgorithm = new BellmanFordAlgorithm(vertexList, edgeList);
        bellmannFordAlgorithm.computeShortestPath(vertexList.get(0));
        bellmannFordAlgorithm.displayPath(vertexList.get(3));
    }

    public void computeShortestPath(Vertex sourceVertex) {
        sourceVertex.setDistance(0d);
        for (Vertex vertex : this.vertices) {
            this.edges.stream().filter(edge -> edge.getStartVertex().getDistance() != Double.MAX_VALUE).forEach(edge -> {
                final double newDistance = edge.getStartVertex().getDistance() + edge.getWeight();
                if (newDistance < edge.getEndVertex().getDistance()) {
                    edge.getEndVertex().setDistance(newDistance);
                    edge.getEndVertex().setPrevVertex(edge.getStartVertex());
                }
            });
        }
        for (Edge edge : this.edges) {
            if (edge.getStartVertex().getDistance() != Double.MAX_VALUE && hasCylce(edge)) {
                System.out.println("Has cycle");
                return;
            }
        }
    }

    private void displayPath(Vertex vertex) {
        if(vertex != null) {
            displayPath(vertex.getPrevVertex());
            System.out.print(vertex + ", ");
        }
    }

    private boolean hasCylce(Edge edge) {
        return edge.getEndVertex().getDistance() < edge.getWeight() + edge.getStartVertex().getDistance();
    }
}
