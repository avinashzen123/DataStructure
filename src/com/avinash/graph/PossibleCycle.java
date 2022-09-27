package com.avinash.graph;

import java.util.HashSet;
import java.util.Set;

public class PossibleCycle {
	public static boolean cycleInGraph(int[][] edges) {
		for (int vertex = 0; vertex < edges.length; vertex++) {
			if (dfs(edges, vertex, new HashSet<>())) {
				return true;
			}
		}
		return false;
	}

	private static boolean dfs(int[][] edges, int vertex, Set<Integer> visited) {
		if (visited.contains(vertex))
			return true;
		visited.add(vertex);
		for (int edge : edges[vertex]) {
			if (dfs(edges, edge, visited)) {
				return true;
			}
		}
		visited.remove(vertex);
		return false;
	}

	public static void main(String[] args) {
		int[][] edges = { {}, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0 } };
		System.out.println(cycleInGraph(edges));
		edges = new int[][] { { 1, 2 }, { 2 }, { 0 } };
		System.out.println(cycleInGraph(edges));
		edges = new int[][] { { 1 }, { 2, 3, 4, 5, 6, 7 }, {}, { 2, 7 }, { 5 }, {}, { 4 }, {} };
		System.out.println(cycleInGraph(edges));

		edges = new int[][] { {}, { 0, 3 }, { 0 }, { 1, 2 } };
		System.out.println(cycleInGraph(edges));
	}
}
