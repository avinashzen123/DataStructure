package com.avinash.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class ReachableNodeWithMaxMoves {
	static class Node {
		int node;
		int dist;
		Node(int n, int d) {
			this.node = n;
			this.dist = d;
		}
	}
	public int reachableNodes(int[][] edges, int maxMoves, int n) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int w = edge[2];
			graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, w);
			graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, w);
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		Map<Integer, Integer> distance = new HashMap<>();
		distance.put(0, 0);
		Map<Integer, Integer> used = new HashMap<>();
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nextNode = node.node;
			int d = node.dist;
			if (d > distance.getOrDefault(node, 0)) continue;
			// Each node is only visited once. We have reached 
			// a node in our original graph
			ans++;
			if (!graph.containsKey(nextNode)) continue;
			for (int nei : graph.get(nextNode).keySet()) {
				// maxMoves - d is how much further we can walk from this node
				// Weight is how many new nodes there are on this edge.
				// v is the maximum utilisation of this edge
				int weight = graph.get(nextNode).get(nei);
				int v = Math.min(weight, maxMoves - d);
				used.put(n * nextNode + nei, maxMoves - d);
				int d2 = d + weight + 1;
				if (d2 < distance.getOrDefault(nei, maxMoves + 1)) {
					pq.offer(new Node(nei, d2));
					distance.put(nei, d2);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 10 }, { 0, 2, 1 }, { 1, 2, 2 } };
		int maxMoves = 6;
		int n = 3;
	}
}
