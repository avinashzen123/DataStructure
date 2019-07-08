package com.avinash.hamiltonian.cycle;

public class Edge {
	private final Vertex startVertex, endVertex;

	public Edge(Vertex startVertex, Vertex endVertex) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	@Override
	public String toString() {
		return startVertex + " " + endVertex + " - ";
	}
}
