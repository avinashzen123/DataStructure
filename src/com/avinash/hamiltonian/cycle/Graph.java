package com.avinash.hamiltonian.cycle;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private final List<List<Edge>> adjacencies;
	private final List<Vertex> vertexs;
	public Graph(int numberOfVertices, List<Vertex> vertexs) {
		this.adjacencies = new ArrayList<List<Edge>>();
		this.vertexs = vertexs;
		for (int i = 0; i < numberOfVertices; i++) {
			this.adjacencies.add(new ArrayList<Edge>());
		}
	}

	public List<List<Edge>> getAdjacencies() {
		return adjacencies;
	}

	public void addAdjacency(Edge edge) {
		this.adjacencies.get(edge.getStartVertex().getId()).add(edge);
//		this.adjacencies.get(edge.getEndVertex().getId()).add(edge);
	}

	public List<Vertex> getVertexs() {
		return vertexs;
	}
	
}
