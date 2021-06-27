package com.avinash.primsjarnik;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsJarnikAlgo {
	private final List<Vertex> unvisitedVertex;
	private final List<Edge> mst;
	private final PriorityQueue<Edge> edgesHeap;
	private Double minCost;

	public PrimsJarnikAlgo(List<Vertex> unvisitedVertex) {
		this.unvisitedVertex = unvisitedVertex;
		this.mst = new ArrayList<>();
		this.edgesHeap = new PriorityQueue<>();
		this.minCost = 0.0;
	}

	public void primsAlgorithm(Vertex vertex) {
		unvisitedVertex.remove(vertex);
		while (!unvisitedVertex.isEmpty()) {
			vertex.getNeighbors().stream().filter(edge -> this.unvisitedVertex.contains(edge.getEnd()))
					.forEach(this.edgesHeap::add);

			Edge edge = this.edgesHeap.remove();
			this.mst.add(edge);
			this.minCost += edge.getWeight();
			this.unvisitedVertex.remove(edge.getEnd());
			vertex = edge.getEnd();
		}
		System.out.println(this.minCost);
		this.mst.forEach(System.out::print);
	}
}
