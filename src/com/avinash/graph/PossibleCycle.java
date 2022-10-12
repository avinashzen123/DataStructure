package com.avinash.graph;

import java.util.Arrays;
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
	
	
	public static boolean cycleInGraphUsinColor(int[][] edges) {
		int numberOfEdges = edges.length;
		int[] colors = new int[numberOfEdges];
		Arrays.fill(colors, 0);
		for (int node = 0; node < numberOfEdges; node++) {
			if (colors[node] != 0) {
				continue;
			}
			boolean containsCycle = traverseAndColorNodes(node, edges, colors);
			if (containsCycle) {
				return true;
			}
		}
		return false;
	}

	private static boolean traverseAndColorNodes(int node, int[][] edges, int[] colors) {
		colors[node] = 1;
		int[] neighbors = edges[node];
		for (int neighbor : neighbors) {
			int neighborColor = colors[neighbor];
			if (neighborColor == 1) {
				return true;
			} else if (neighborColor == 0) {
				continue;
			} else {
				boolean containsCycle = traverseAndColorNodes(neighbor, edges, colors);
				if (containsCycle) {
					return true;
				}
				
			}
		}
		colors[node] = 2;
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
		
		System.out.println("----------");
		edges = new int[][] { {}, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0 } };
		System.out.println(cycleInGraphUsinColor(edges));
		edges = new int[][] { { 1, 2 }, { 2 }, { 0 } };
		System.out.println(cycleInGraphUsinColor(edges));
		edges = new int[][] { { 1 }, { 2, 3, 4, 5, 6, 7 }, {}, { 2, 7 }, { 5 }, {}, { 4 }, {} };
		System.out.println(cycleInGraphUsinColor(edges));

		edges = new int[][] { {}, { 0, 3 }, { 0 }, { 1, 2 } };
		System.out.println(cycleInGraphUsinColor(edges));
	}
}
