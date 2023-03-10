package com.avinash.backtracking;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

	/**
	 * Time Complexity O(m * n)
	 *
	 */
	private static class DFS {
		public int numIsLand(char[][] grid) {
			if (grid == null || grid.length == 0)
				return 0;
			int numIsLand = 0;
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col++) {
					if (grid[row][col] == '1') {
						++numIsLand;
						dfs(grid, row, col);
					}
				}
			}
			return numIsLand;
		}

		private void dfs(char[][] grid, int row, int col) {
			if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
				return;
			}
			grid[row][col] = '0';
			dfs(grid, row + 1, col);
			dfs(grid, row - 1, col);
			dfs(grid, row, col + 1);
			dfs(grid, row, col - 1);
		}
	}

	private static class BFS {
		public int numIsLands(char[][] grid) {
			if (grid == null || grid.length == 0)
				return 0;
			int rows = grid.length;
			int cols = grid[0].length;
			int islands = 0;
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					if (grid[row][col] == '1' && !visited[row][col]) {
						searchIsLands(grid, visited, row, col);
						islands++;
					}
				}
			}
			return islands;
		}

		private void searchIsLands(char[][] grid, boolean[][] visited, int row, int col) {
			Queue<int[]> queue = new LinkedList<>();
			visited[row][col] = true;
			queue.add(new int[] { row, col });
			int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

			while (!queue.isEmpty()) {
				int[] position = queue.poll();
				for (int[] direction : directions) {
					int newRow = position[0] + direction[0];
					int newCol = position[1] + direction[1];
					if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
							&& grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
						queue.add(new int[] { newRow, newCol });
						visited[newRow][newCol] = true;
					}
				}
			}
		}
	}

	private static class UnionFind {
		int count = 0;
		int[] parent;
		int[] rank;
		char[][] grid;
		public UnionFind(char[][] grid) {
			this.grid = grid;
			count = 0;
			parent = new int[grid.length * grid[0].length];
			rank = new int[grid.length * grid[0].length];
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col++) {
					if (grid[row][col] == '1') {
						parent[row * grid[0].length + col] = row * grid[0].length + col;
						++count;
					}
					rank[row * grid[0].length + col] = 0;
				}
			}
		}

		public int find(int i) {
			if (parent[i] != i) {
				parent[i] = find(parent[i]);
			}
			return parent[i];
		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {
				if (rank[rootX] > rank[rootY]) {
					parent[rootY] = rootX;
				} else if (rank[rootX] < rank[rootY]) {
					parent[rootX] = rootY;
				} else {
					parent[rootY] = rootX;
					rank[rootX]++;
				}
				--count;
			}
		}

		public int numIsLand() {
			if (grid == null || grid.length == 0)
				return 0;
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col++) {
					if (grid[row][col] == '1') {
						grid[row][col] = '0';
						if (row - 1 >= 0 && grid[row - 1][col] == '1') {
							union(row * grid[0].length + col, (row - 1) * grid[0].length + col);
						}
						if (row + 1 < grid.length && grid[row + 1][col] == '1') {
							union(row * grid[0].length + col, (row + 1) * grid[0].length + col);
						}
						if (col - 1 >= 0 && grid[row][col - 1] == '1') {
							union(row * grid[0].length + col, row * grid[0].length + (col - 1));
						}
						if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
							union(row * grid[0].length + col, row * grid[0].length + (col + 1));
						}
					}
				}
			}
			return count;
		}
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(new BFS().numIsLands(grid));

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(new BFS().numIsLands(grid));

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(new DFS().numIsLand(grid));

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(new UnionFind(grid).numIsLand());

	}
}
