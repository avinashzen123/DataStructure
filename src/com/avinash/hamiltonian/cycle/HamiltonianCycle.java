package com.avinash.hamiltonian.cycle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HamiltonianCycle {

	private final Graph graph;
	private final List<Vertex> path;

	public HamiltonianCycle(Graph graph) {
		this.graph = graph;
		this.path = new ArrayList<>();
	}

	public void hamiltonianCycle(Vertex vertex) {
		this.path.add(vertex);
		if (hamiltonianUtil(vertex) == false) {
			System.out.println("\nSolution does not exist");
		}
	}

	private boolean hamiltonianUtil(Vertex vertex) {
		if (this.path.size() == this.graph.getVertexs().size()) {
			for (Edge edge : this.graph.getAdjacencies().get(vertex.getId())) {
				if (edge.getEndVertex() == this.path.get(0)) {
					return true;
				}
			}
			return false;
		}
		for (Edge edge : this.graph.getAdjacencies().get(vertex.getId())) {
			if (!this.path.contains(edge.getEndVertex())) {//isSafe(edge.getEndVertex(), vertex)
				this.path.add(edge.getEndVertex());
				if (hamiltonianUtil(edge.getEndVertex())) {
					return true;
				} else {
					this.path.remove(edge.getEndVertex());
				}
			}
		}
		return false;
	}

	public void displayCycle() {
		for (Vertex vertex: this.path) {
			System.out.print(vertex + " ");
		}
		System.out.println(this.path.get(0));
	}

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
