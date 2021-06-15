package com.avinash.traversal.topologicalorder.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Vertex> graph = new ArrayList<Vertex>();
		Vertex V0 = new Vertex("S");
		Vertex V1 = new Vertex("A");
		Vertex V2 = new Vertex("B");
		Vertex V3 = new Vertex("C");
		Vertex V4 = new Vertex("D");
		Vertex V5 = new Vertex("E");
		
		V0.setNeighbor(new Edge(V1, 1));
		V0.setNeighbor(new Edge(V3, 2));
		
		V1.setNeighbor(new Edge(V2, 6));
		
		V2.setNeighbor(new Edge(V4, 1));
		V2.setNeighbor(new Edge(V5, 2));
		
		V3.setNeighbor(new Edge(V1, 4));
		V3.setNeighbor(new Edge(V4, 3));
		
		V4.setNeighbor(new Edge(V5, 1));
		
		graph.add(V0);
		graph.add(V1);
		graph.add(V2);
		graph.add(V3);
		graph.add(V4);
		graph.add(V5);
		
		ShortestPath path = new ShortestPath(graph);
		path.compute();
		graph.forEach(vertex -> {
			System.out.println("Distance from S :" + vertex.getMinDistance() + " - " + vertex.getPredecessor());
		});
		
	}
}
