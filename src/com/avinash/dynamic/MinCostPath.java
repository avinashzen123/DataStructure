package com.avinash.dynamic;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;


import static java.lang.Math.min;

// https://www.geeksforgeeks.org/min-cost-path-dp-6/
/*
 * Time Complexity: O((M * N)3)
 * Auxiliary Space: O(M + N), for recursive stack space
 */
class MinCostPathRecursive {
	private static int minCost(int[][] cost, int row, int col) {
		if (row < 0 || col < 0)
			return Integer.MAX_VALUE;
		if (row == 0 && col == 0)
			return cost[row][col];
		return cost[row][col] + Math.min(Math.min(minCost(cost, row - 1, col - 1), minCost(cost, row, col - 1)),
				minCost(cost, row - 1, col));
	}

	public static int minCost(int[][] cost) {
		return minCost(cost, cost.length - 1, cost[0].length - 1);
	}
}

class MinCostPathDp {
	/*
	 * Time Complexity: O(M * N)
	 * 
	 * Auxiliary Space: O(M * N)
	 */
	public static int minCost(int[][] cost) {
		int rows = cost.length - 1;
		int cols = cost[0].length - 1;

		int[][] dp = new int[rows + 1][cols + 1];
		dp[0][0] = cost[0][0];

		IntStream.rangeClosed(1, rows).forEach(i -> dp[i][0] = dp[i - 1][0] + cost[i][0]);
		IntStream.rangeClosed(1, cols).forEach(i -> dp[0][i] = dp[0][i - 1] + cost[0][i]);

		for (int row = 1; row <= rows; row++) {
			for (int col = 1; col <= cols; col++) {
				dp[row][col] = cost[row][col]
						+ Math.min(Math.min(dp[row - 1][col - 1], dp[row - 1][col]), dp[row][col - 1]);
			}
		}

		Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);

		return dp[rows][cols];
	}

	/*
	 * Time Complexity: O(N * M), where N is the number of rows and M is the number
	 * of columns
	 * 
	 * Auxiliary Space: O(1), since no extra space has been taken
	 */
	public static int minCostSpaceOptimized(int[][] cost) {
		int rows = cost.length - 1;
		int cols = cost.length - 1;

		// For columns
		IntStream.rangeClosed(1, rows).forEach(i -> cost[i][0] += cost[i - 1][0]);
		// For rows
		IntStream.rangeClosed(1, cols).forEach(i -> cost[0][i] += cost[0][i - 1]);

		for (int row = 1; row <= rows; row++) {
			for (int col = 1; col <= cols; col++) {
				cost[row][col] += min(min(cost[row - 1][col - 1], cost[row - 1][col]), cost[row][col - 1]);
			}
		}
		Arrays.stream(cost).map(Arrays::toString).forEach(System.out::println);
		return cost[rows][cols];
	}
}

class DijkstraAlgorithm {
	int rows;
	int cols;
	int[][] costs;
    int dx[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
    int dy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
    
	public DijkstraAlgorithm(int[][] costs) {
		this.costs = costs;
		this.rows = costs.length;
		this.cols = costs[0].length;
	}

	class DijkstraCell {
		int x, y, cost;

		public DijkstraCell(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	public boolean isSafe(int x, int y) {
		return x >= 0 && x < rows && y >= 0 && y < cols;
	}

	/*
	 * This solution is based on Dijkstra's shortest path algorithm
	 * 
	 * 		For each unit square being visited, we examine all possible move in 8
	 * 		directions.
	 * 
	 * 			Calculate the accumulated cost of path for each next move, adjust the cost of
	 * 				adjacent units to minimum as needed.
	 * 			
	 * 			then add the valid next moves into a mean Heap.
	 * 
	 * 		The min Heap pops out the next move with the minimum accumulated cost of path.
	 * 		
	 * 		once the iteration reaches the last unit at the lower right corner, the minimum
	 * 		cost path will be returned
	 */

	public int minCost() {
		int[][] dp = new int[rows][cols];
		boolean [][] visited = new boolean[rows][cols];
		PriorityQueue<DijkstraCell> priorityQueue = new PriorityQueue<>((DijkstraCell lhs, DijkstraCell rhs) -> {
			return lhs.cost - rhs.cost;
		});
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				dp[row][col] = Integer.MAX_VALUE;
				visited[row][col] = false;
			}
		}
		
	
		
		dp[0][0] = costs[0][0];
		priorityQueue.add(new DijkstraCell(0, 0, costs[0][0]));
		while(!priorityQueue.isEmpty()) {
			DijkstraCell cell = priorityQueue.poll();
			if (visited[cell.x][cell.y]) {
				continue;
			}
			visited[cell.x][cell.y] = true;
			for (int i = 0; i < 8; i ++) {
				int nextX = cell.x + dx[i];
				int nextY = cell.y + dy[i];
				if (isSafe(nextX, nextY) && !visited[nextX][nextY]) {
					dp[nextX][nextY] = min(dp[nextX][nextY],
							dp[cell.x][cell.y] + costs[nextX][nextY]);
					priorityQueue.add(new DijkstraCell(nextX, nextY, dp[nextX][nextY]));
				}
			}
		}
		Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
		return dp[rows - 1][cols - 1];
	}
}

public class MinCostPath {

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		
		System.out.println(new DijkstraAlgorithm(cost).minCost());
		

		System.out.println(MinCostPathRecursive.minCost(cost));
		System.out.println(MinCostPathDp.minCost(cost));
		System.out.println(MinCostPathDp.minCostSpaceOptimized(cost));
		System.out.println("------------");
		
	}
}
