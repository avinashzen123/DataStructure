package com.avinash.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

// https://leetcode.com/problems/graph-valid-tree/editorial/
public class GraphValidTree {

	static class IterativeDFS {
		static boolean validTree(int n, int[][] edges) {
			List<List<Integer>> adjacencyList = new ArrayList<>();
			IntStream.range(0, n).forEach(i -> adjacencyList.add(new ArrayList<>()));
			Arrays.stream(edges).forEach(edge -> {
				adjacencyList.get(edge[0]).add(edge[1]);
				adjacencyList.get(edge[1]).add(edge[0]);
			});
			Map<Integer, Integer> parent = new HashMap<>();
			parent.put(0, -1);
			Stack<Integer> stack = new Stack<>();
			stack.push(0);
			while (!stack.isEmpty()) {
				int node = stack.pop();
				for (int neighbour : adjacencyList.get(node)) {
					if (parent.get(node) == neighbour) {
						continue;
					}
					if (parent.containsKey(neighbour)) {
						return false;
					}
					stack.push(neighbour);
					parent.put(neighbour, node);
				}
			}
			return parent.size() == n;
		}
	}

	static class RecursiveDFS {
		static boolean validTree(int n, int[][] edges) {
			if (edges.length != n - 1) return false;
			List<List<Integer>> adjacencyList = new ArrayList<>();
			Set<Integer> seen = new HashSet<>();
			
			IntStream.range(0, n).forEach(i -> adjacencyList.add(new ArrayList<>()));
			Arrays.stream(edges).forEach(edge -> {
				adjacencyList.get(edge[0]).add(edge[1]);
				adjacencyList.get(edge[1]).add(edge[0]);
			});
			return dfs(adjacencyList, seen, 0, -1) && seen.size() == n;
		}

		private static boolean dfs(List<List<Integer>> adjacencyList, Set<Integer> seen, int node, int parent) {
			if (seen.contains(node)) return false;
			seen.add(node);
			for (int neighbour : adjacencyList.get(node)) {
				if (parent != neighbour) {
					boolean result = dfs(adjacencyList, seen, neighbour, node);
					if (!result) return false;
				}
			}
			return true;
		}
	}
	
	static class IterativeBFS {
		static boolean validTree(int n, int[][] edges) {
			if (edges.length != n - 1) return false;
			List<List<Integer>> adjacencyList = new ArrayList<>();
			IntStream.range(0, n).forEach(i -> adjacencyList.add(new ArrayList<>()));
			Arrays.stream(edges).forEach(edge -> {
				adjacencyList.get(edge[0]).add(edge[1]);
				adjacencyList.get(edge[1]).add(edge[0]);
			});
			Queue<Integer> queue = new LinkedList<>();
			Set<Integer> seen = new HashSet<>();
			queue.offer(0);
			seen.add(0);
			while(!queue.isEmpty()) {
				int node = queue.poll();
				for (int neighbour : adjacencyList.get(node)) {
					if (seen.contains(neighbour)) continue;
					seen.add(neighbour);
					queue.offer(neighbour);
				}
			}
			return seen.size() == n;
		}
	}
	
	
	static class UnionFindWithoutOptimization {
		private int[] parent;
		
		public void UnionFind(int n) {
			parent = new int[n];
			for (int node = 0; node < n; node++) {
				parent[node] = node;
			}
		}
		
		public int find(int a) {
			while(parent[a] != a) {
				a = parent[a];
			}
			return a;
		}
		
		public boolean union(int a, int b) {
			int rootA = find(a);
			int rootB = find(b);
			if (rootA == rootB) {
				return false;
			}
			parent[rootA] = rootB;
			return true;
		}
		
		public boolean validTree(int n, int[][] edges) {
			if (edges.length != n - 1) return false;
			UnionFind(n);
			for (int[] edge : edges) {
				int a = edge[0];
				int b = edge[1];
				if (!union(a, b)) {
					return false;
				}
			}
			// If we got this far, there is no cycle.
			return true;
		}
	}
	
	static class UnionFindWithPathOptimization {
		int[] parent;
		int[] size;
		
		public void UnionFind(int n) {
			parent = new int[n];
			size = new int[n];
			for (int node = 0; node < n; node++) {
				parent[node] = node;
				size[node] = 1;
			}
		}
		
		public int find(int a) {
			// Step 1 : find the root
			int root = a;
			while(parent[root] != root) {
				root = parent[root];
			}
			// Step 2 : Do a second traversal , this time setting each node to point directly at a as we go
			while(a != root) {
				int oldRoot = parent[a];
				parent[a] = root;
				a = oldRoot;
			}
			return root;
		}
		
		public boolean union(int a, int b) {
			int rootA = find(a);
			int rootB = find(b);
			if (rootA == rootB) return false;
			if (size[rootA] < size[rootB]) {
				parent[rootA] = rootB;
				size[rootB] += size[rootA];
			} else {
				parent[rootB] = rootA;
				size[rootA] += size[rootB];
			}
			return true;
		}
		
		public boolean validTree(int n, int[][] edges) {
			if (edges.length != n - 1) return false;
			UnionFind(n);
			for (int[] edge : edges) {
				int a = edge[0];
				int b = edge[1];
				if (!union(a, b)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int n = 5;
//		System.out.println(IterativeBFS.validTree(n, edges));
		System.out.println(new UnionFindWithPathOptimization().validTree(n, edges));
		int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		int n1 = 5;
//		System.out.println(IterativeBFS.validTree(n1, edges1));
		System.out.println(new UnionFindWithPathOptimization().validTree(n1, edges1));
	}
}
