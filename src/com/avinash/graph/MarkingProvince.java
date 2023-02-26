package com.avinash.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-provinces/description/
public class MarkingProvince {
	private static class DFS {

		/*
		 * O(N^2)
		 */
		private void dfs(int[][] m, int[] visited, int i) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 1 && visited[j] == 0) {
					visited[j] = 1;
					dfs(m, visited, j);
				}
			}
		}

		public int findCircleNum(int[][] m) {
			int[] visited = new int[m.length];
			int count = 0;
			for (int i = 0; i < m.length; i++) {
				if (visited[i] == 0) {
					dfs(m, visited, i);
					count++;
				}
			}
			return count;
		}
	}

	private static class BFS {
		/*
		 * O(N^2)
		 */
		public int findCircleNum(int[][] m) {
			boolean[] visited = new boolean[m.length];
			int count = 0;
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < m.length; i++) {
				if (!visited[i]) {
					queue.add(i);
					while (!queue.isEmpty()) {
						int s = queue.poll();
						visited[s] = true;
						for (int j = 0; j < m.length; j++) {
							if (m[s][j] == 1 && !visited[j]) {
								queue.add(j);
							}
						}
					}
					count++;
				}
			}
			return count;
		}
	}

	private static class UnionFindMethod {
		public int findCircleNum(int[][] m) {
			int[] parent = new int[m.length];
			Arrays.fill(parent, -1);
			for (int sourceIdx = 0; sourceIdx < m.length; sourceIdx++) {
				for (int targetIdx = 0; targetIdx < m.length; targetIdx++) {
					if (m[sourceIdx][targetIdx] == 1 && sourceIdx != targetIdx) {
						union(parent, sourceIdx, targetIdx);
					}
				}
			}
			int count = 0;
			for (int i = 0; i < m.length; i++) {
				if (parent[i] == -1) {
					count++;
				}
			}
			return count;
		}

		private void union(int[] parent, int sourceIdx, int targetIdx) {
			int sourceSet = find(parent, sourceIdx);
			int targetSet = find(parent, targetIdx);
			if (sourceSet != targetSet) {
				parent[sourceIdx] = targetSet;
			}
		}

		private int find(int[] parent, int vertex) {
			if (parent[vertex] == -1) {
				return vertex;
			}
			return find(parent, parent[vertex]);
		}
	}

	public static void main(String[] args) {
		System.out.println(new DFS().findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println(new BFS().findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println(new UnionFindMethod().findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
	}
}
