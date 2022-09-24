package com.avinash.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {

	public static int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int freshCount = 0;
		int time = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 1) {
					freshCount++;
				} else if (grid[row][col] == 2) {
					queue.add(new int[] { row, col });
				}
			}
		}
		int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!queue.isEmpty() && freshCount > 0) {
			time++;
			int currentQSize = queue.size();
			for (int i = 0; i < currentQSize; i++) {
				int[] rotten = queue.poll();
				int row = rotten[0];
				int col = rotten[1];
				for (int[] dir : dirs) {
					int x = row + dir[0];
					int y = col + dir[1];
					if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
						grid[x][y] = 2;
						queue.add(new int[] { x, y });
						freshCount--;
					}
				}
			}
		}
		return freshCount == 0 ? time : 0;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting(grid));
	}
}
