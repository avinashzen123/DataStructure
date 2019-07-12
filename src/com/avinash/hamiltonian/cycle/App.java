package com.avinash.hamiltonian.cycle;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
                { 0, 1, 1, 1, 0 }, };
//		int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
//				{ 0, 1, 1, 0, 0 }, };
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < graph1.length; i++) {
            vertices.add(new Vertex(i));
        }
        Graph graph = new Graph(graph1.length, vertices);
        for (int i = 0; i < graph1.length; i++) {
            for (int j = 0; j < graph1.length; j++) {
                if (graph1[i][j] != 0) {
                    graph.addAdjacency(new Edge(vertices.get(i), vertices.get(j)));
                }
            }
        }
        HamiltonianCycle cycle = new HamiltonianCycle(graph);
        cycle.hamiltonianCycle(graph.getVertexs().get(0));
        cycle.displayCycle();
    }
}
