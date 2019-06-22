package com.avinash.path.shortest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    private final List<Vertex> vertices;
    private final List<Edge> edges;

    public DijkstraAlgorithm(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void computeShortesPath(Vertex vertex) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        vertex.setDistance(0d);
        queue.add(vertex);
        while (!queue.isEmpty()) {
            final Vertex polledObject = queue.poll();
            this.edges.stream().filter(edge -> edge.getStartVertex() == polledObject).forEach(edge -> {
                final double newDistance = edge.getWeight() + polledObject.getDistance();
                if(newDistance < edge.getEndVertex().getDistance()) {
                    edge.getEndVertex().setDistance(newDistance);
                    edge.getEndVertex().setPrevVertex(edge.getStartVertex());
                    queue.remove(edge.getEndVertex());
                    queue.add(edge.getEndVertex());
                }
            });
        }
    }

    private void displayPath(Vertex vertex) {
        if(vertex != null) {
            displayPath(vertex.getPrevVertex());
            System.out.print(vertex + ", ");
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        List<Vertex> vertexes = new ArrayList<Vertex>();
        for (int i = 0; i < graph.length; i++) {
            vertexes.add(new Vertex(i + ""));
        }
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < graph.length; i++) {
            int[] array = graph[i];
            for (int j = 0; j < array.length; j++) {
                if(graph[i][j] != 0) {
                    edges.add(new Edge(vertexes.get(i), vertexes.get(j), (double)graph[i][j]));
                }
            }
        }

        DijkstraAlgorithm shortestPath1 = new DijkstraAlgorithm(vertexes, edges);
        shortestPath1.computeShortesPath(vertexes.get(0));
        shortestPath1.displayPath(vertexes.get(3));

    }

}
