package com.avinash.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

	private static class Item implements Comparable<Item> {
		public int id;
		public int totalDistance;
		public int distance;

		public Item(int id, int totalDistance, int distance) {
			this.id = id;
			this.totalDistance = totalDistance;
			this.distance = distance;
		}

		public int compareTo(Item o) {
			return this.distance - o.distance;
		}

		public int hashCode() {
			return id;
		}

		public boolean equals(Object o) {
			Item other = (Item) o;
			return this.id == other.id;
		}
	}

	public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		// Write your code here.
		int[] result = new int[edges.length];
		Arrays.fill(result, -1);
		PriorityQueue<Item> queue = new PriorityQueue<>();
		Set<Integer> visited = new HashSet<>();
		Arrays.stream(edges[start]).forEach(edge -> queue.add(new Item(edge[0], edge[1], edge[1])));
		result[start] = 0;
		visited.add(start);

		while (visited.size() < edges.length && !queue.isEmpty()) {
			Item nextNode = queue.poll();
			if (!visited.contains(nextNode.id)) {
				visited.add(nextNode.id);
				result[nextNode.id] = nextNode.totalDistance;
				for (int[] edge : edges[nextNode.id]) {
					if (!visited.contains(edge[0])) {
						queue.add(new Item(edge[0], edge[1] + nextNode.totalDistance, edge[1]));
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][][] edges = { { { 2, 4 } }, { { 0, 2 } }, { { 1, 1 }, { 3, 2 } }, { { 0, 3 } } };
		System.out.println(Arrays.toString(new Dijkstra().dijkstrasAlgorithm(3, edges)));
	}
}
