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
			System.out.println("Solution does not exist");
		}
	}

	private boolean hamiltonianUtil(Vertex vertex) {
		if (this.path.size() == this.graph.getVertexs().size()) {
			return this.graph.getAdjacencies().get(vertex.getId()).stream().map(Edge::getEndVertex).collect(Collectors.toList()).contains(this.path.get(0));
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
		this.path.forEach(System.out::print);
		System.out.println(this.path.get(0));
	}
}
