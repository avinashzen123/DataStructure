package com.avinash.traversal.topologicalorder.shortestpath;
public class Edge {
	private final Vertex target;
	private final int weight;

	public Edge(Vertex target, int weight) {
		this.target = target;
		this.weight = weight;
	}

	public Vertex getTarget() {
		return target;
	}

	public int getWeight() {
		return weight;
	}
	
}
