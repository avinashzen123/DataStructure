package com.avinash.graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
	public static int numIsLands(char[][] grid) {
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

	private static void searchIsLands(char[][] grid, boolean[][] visited, int row, int col) {
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

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIsLands(grid));

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numIsLands(grid));

	}
}
