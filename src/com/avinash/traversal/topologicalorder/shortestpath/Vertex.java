package com.avinash.traversal.topologicalorder.shortestpath;

import java.util.ArrayList;
import java.util.List;


public class Vertex {
	private String name;
	private boolean visited;
	private int minDistance;
	private Vertex predecessor;
	private List<Edge> adjacencyList;
	
	public Vertex(String name) {
		super();
		this.minDistance = Integer.MAX_VALUE;
		this.adjacencyList = new ArrayList<Edge>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public List<Edge> getNeighbor() {
		return adjacencyList;
	}

	public void setNeighbor(Edge edge) {
		this.adjacencyList.add(edge);
	}
	
	@Override
	public String toString() {
		return name + ", " + predecessor ;
	}

	
}
