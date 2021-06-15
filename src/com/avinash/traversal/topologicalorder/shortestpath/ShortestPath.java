package com.avinash.traversal.topologicalorder.shortestpath;

import java.util.List;
import java.util.Stack;

public class ShortestPath {
	private TopologicalOrdering ordering;

	public ShortestPath(List<Vertex> graph) {
		super();
		this.ordering = new TopologicalOrdering(graph);
	}
	
	public void compute() {
		Stack<Vertex> topologicalOrder = this.ordering.getStack();
		while(!topologicalOrder.isEmpty()) {
			Vertex u = topologicalOrder.pop();
			for (Edge edge: u.getNeighbor()) {
				Vertex v = edge.getTarget();
				if (v.getMinDistance() > edge.getWeight() + u.getMinDistance()) {
					v.setMinDistance(u.getMinDistance() + edge.getWeight());
					v.setPredecessor(u);
				}
			}
		}
	}
}
