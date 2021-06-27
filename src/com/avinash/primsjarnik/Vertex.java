package com.avinash.primsjarnik;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private final String name;
	private final List<Edge> neighbors;

	public Vertex(String name) {
		super();
		this.name = name;
		this.neighbors = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Edge> getNeighbors() {
		return neighbors;
	}

	public void addEdge(Edge edge) {
		this.neighbors.add(edge);
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Vertex)obj).getName());
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
