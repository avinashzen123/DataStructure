package com.avinash.array;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfPasses {

	public int minimumPassesOfMatrix(int[][] matrix) {
		Queue<int[]> queue = new LinkedList<>();
		int passes = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] > 0) {
					queue.add(new int[] { row, col });
				}
			}
		}
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			passes++;
			while (queueSize > 0) {
				int pos[] = queue.poll();
				addToQueue(matrix, pos[0] + 1, pos[1], queue);
				addToQueue(matrix, pos[0] - 1, pos[1], queue);
				addToQueue(matrix, pos[0], pos[1] + 1, queue);
				addToQueue(matrix, pos[0], pos[1] - 1, queue);
				queueSize--;
			}
		}
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] < 0)
					return -1;
			}
		}
		return passes - 1;
	}

	private void addToQueue(int[][] matrix, int row, int col, Queue<int[]> queue) {
		if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] < 0) {
			matrix[row][col] *= -1;
			queue.add(new int[] { row, col });
		}
	}

	public static void main(String[] args) {
		MinimumNumberOfPasses minimumNumberOfPasses = new MinimumNumberOfPasses();
		int[][] matrix = new int[][] { { 0, -2, -1 }, { -5, 2, 0 }, { -6, -2, 0 } };
		matrix = new int[][] { { 0, -2, -1 }, { -5, 2, 0 }, { -6, -2, 0 } };
		System.out.println(minimumNumberOfPasses.minimumPassesOfMatrix(matrix));

		matrix = new int[][] { { 0, -1, -3, 2, 0 }, { 1, -2, -5, -1, -3 }, { 3, 0, 0, -4, -1 } };
		System.out.println(minimumNumberOfPasses.minimumPassesOfMatrix(matrix));

	}
}
