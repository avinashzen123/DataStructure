package com.avinash.primsjarnik;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		List<Vertex> vertexList = new ArrayList<>();

		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");

		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);

		vertex0.addEdge(new Edge(vertex0, vertex1, (double)1));
		vertex0.addEdge(new Edge(vertex0, vertex2, (double)1));
		vertex1.addEdge(new Edge(vertex1, vertex2, (double)10));

		vertex1.addEdge(new Edge(vertex1, vertex0, (double)1));
		vertex2.addEdge(new Edge(vertex2, vertex0, (double)1));
		vertex2.addEdge(new Edge(vertex2, vertex1, (double)10));

		PrimsJarnikAlgo algorithm = new PrimsJarnikAlgo(vertexList);

		algorithm.primsAlgorithm(vertex2);

	}
}
