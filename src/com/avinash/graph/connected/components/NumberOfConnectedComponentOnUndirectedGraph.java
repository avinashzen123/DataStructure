package com.avinash.graph.connected.components;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberOfConnectedComponentOnUndirectedGraph {

	public int countComponents(int n, int[][] edges) {
		int component = 0;
		List<List<Integer>> adjacencyList = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> adjacencyList.add(new ArrayList<>()));
		boolean[] visited = new boolean[n];
		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}
		for (int vertex = 0; vertex < n ; vertex++) {
			if (!visited[vertex]) {
				component++;
				dfs(adjacencyList, visited, vertex);
			}
		}

		return component;
	}

	private void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int vertex) {
		visited[vertex] = true;
		for (int nextVertex : adjacencyList.get(vertex)) {
			if (!visited[nextVertex]) {
				dfs(adjacencyList, visited, nextVertex);
			}
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
		int n = 5;
		NumberOfConnectedComponentOnUndirectedGraph graph = new NumberOfConnectedComponentOnUndirectedGraph();
		System.out.println(graph.countComponents(n, edges));
		
		int[][] edges1 = {{0,1},{1,2},{3,4}};
		int n1 = 5;
		System.out.println(graph.countComponents(n1, edges1));
	}
}
