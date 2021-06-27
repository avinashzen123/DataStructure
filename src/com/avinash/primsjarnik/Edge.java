package com.avinash.primsjarnik;

public class Edge implements Comparable<Edge> {
	private final Vertex start, end;
	private final Double weight;

	public Edge(Vertex start, Vertex end, Double weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public Vertex getStart() {
		return start;
	}

	public Vertex getEnd() {
		return end;
	}

	public Double getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.weight);
	}

	@Override
	public String toString() {
		return start + "-" + end +  " ";
	}
	
	

}
