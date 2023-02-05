package com.avinash.dynamic;

import java.util.Arrays;

//https://www.geeksforgeeks.org/gold-mine-problem/
	
class RecursiveGoldMine {

	private static int collectGold(int[][] gold, int x, int y, int n, int m) {
		if (x < 0 || x == n || y == m) {
			return 0;
		}
		int rightUpperDiagonal = collectGold(gold, x - 1, y + 1, n, m);
		int right = collectGold(gold, x, y + 1, n, m);
		int rightLowerDiagonal = collectGold(gold, x + 1, y + 1, n, m);
		return gold[x][y] + Math.max(Math.max(rightLowerDiagonal, rightUpperDiagonal), right);
	}

	/*
	 * Time Complexity O(3 ^ (m * n) Space complexity O(n * m)
	 */
	public static int getMaxGold(int[][] gold, int n, int m) {
		int maxGold = 0;
		for (int i = 0; i < n; i++) {
			int goldCollected = collectGold(gold, i, 0, n, m);
			maxGold = Math.max(maxGold, goldCollected);
		}
		return maxGold;
	}
}

class BottomUpDpGoldMine {
	private static int collectGold(int[][] gold, int x, int y, int n, int m, int[][] dp) {
		if (x < 0 || x == n || y == m) {
			return 0;
		}
		if (dp[x][y] != -1)
			return dp[x][y];
		int rightUpperDiagonal = collectGold(gold, x - 1, y + 1, n, m, dp);
		int right = collectGold(gold, x, y + 1, n, m, dp);
		int rightLowerDiagonal = collectGold(gold, x + 1, y + 1, n, m, dp);
		return dp[x][y] = gold[x][y] + Math.max(Math.max(rightUpperDiagonal, rightLowerDiagonal), right);
	}

	/*
	 * Time complexity O(m * n) Space complexity O(m * n)
	 */
	public static int getMaxGold(int[][] gold, int n, int m) {
		int maxGold = 0;
		int[][] dp = new int[n][m];
		Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
		for (int i = 0; i < n; i++) {
			int goldCollected = collectGold(gold, i, 0, n, m, dp);
			maxGold = Math.max(maxGold, goldCollected);
		}
		return maxGold;
	}
}

/*
 * Time complexity O(m * n) Space complexity O(m * n)
 */
class TopDownTabulationDpGoldMine {
	static final int MAX = 100;

	public static int getMaxGold(int gold[][], int m, int n) {
		int goldTable[][] = new int[m][n];
		for (int col = n - 1; col >= 0; col--) {
			for (int row = 0; row < m; row++) {
				int right = (col == n - 1) ? 0 : goldTable[row][col + 1];
				int rightUp = (row == 0 || col == n - 1) ? 0 : goldTable[row - 1][col + 1];
				int rightDown = (row == m - 1 || col == n - 1) ? 0 : goldTable[row + 1][col + 1];
				goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(rightUp, rightDown));
			}
		}
		Arrays.stream(gold).forEach(i -> System.out.println(Arrays.toString(i)));
		System.out.println("   ");
		Arrays.stream(goldTable).forEach(i -> System.out.println(Arrays.toString(i)));
		int res = goldTable[0][0];
		for (int i = 1; i < m; i++) {
			res = Math.max(res, goldTable[i][0]);
		}
		return res;
	}
}

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a
 * positive integer which is the amount of gold in tons. Initially, the miner is
 * in the first column but can be in any row. He can move only (right->,right up
 * /,right down\) that is from a given cell, the miner can move to the cell
 * diagonally up towards the right or diagonally down towards the right. Find
 * out the maximum amount of gold he can collect.
 * 
 * Input : mat[][] = {{1, 3, 3}, {2, 1, 4}, {0, 6, 4}}; Output : 12
 * {(1,0)->(2,1)->(1,2)}
 * 
 * Input: mat[][] = { {1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
 * Output : 16 (2,0) -> (1,1) -> (1,2) -> (0,3) OR (2,0) -> (3,1) -> (2,2) ->
 * (2,3)
 * 
 * Input : mat[][] = {{10, 33, 13, 15}, {22, 21, 04, 1}, {5, 0, 2, 3}, {0, 6,
 * 14, 2}}; Output : 83
 */

public class GoldMineProblem {

	public static void main(String[] args) {
		int[][] gold = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		int m = 4, n = 4;
		System.out.println(RecursiveGoldMine.getMaxGold(gold, n, m));
		System.out.println(BottomUpDpGoldMine.getMaxGold(gold, n, m));
		System.out.println(TopDownTabulationDpGoldMine.getMaxGold(gold, n, m));
	}
}
