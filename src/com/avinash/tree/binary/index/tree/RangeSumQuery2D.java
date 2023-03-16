package com.avinash.tree.binary.index.tree;

import java.util.Arrays;

public class RangeSumQuery2D {

	// https://leetcode.com/problems/range-sum-query-2d-immutable/editorial/
	private static class BruteForce {
		private int[][] data;

		public BruteForce(int[][] matrix) {
			this.data = matrix;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			for (int r = row1; r <= row2; r++) {
				for (int c = col1; c <= col2; c++) {
					sum += data[r][c];
				}
			}
			return sum;
		}
	}

	/*
	 * Time complexity: O(m) time per query, O(mn) time
	 * pre-computation. The pre-computation in the constructor takes O(mn)
	 * time. The sumRegion query takes O(m) time.
	 */
	private static class CumulativeSumRowCaching {
		private int[][] dp;

		public CumulativeSumRowCaching(int[][] matrix) {
			if (matrix.length == 0 || matrix[0].length == 0) {
				return;
			}
			dp = new int[matrix.length][matrix[0].length + 1];
			for (int r = 0; r < matrix.length; r++) {
				for (int c = 0; c < matrix[r].length; c++) {
					dp[r][c + 1] = dp[r][c] + matrix[r][c];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			for (int row = row1; row <= row2; row++) {
				sum += dp[row][col2 + 1] - dp[row][col1];
			}
			return sum;
		}
	}

	private static class CumulativeSum2D {
		private int[][] dp;
		
		public CumulativeSum2D(int matrix[][]) {
			if (matrix.length == 0 || matrix[0].length == 0) return;
			dp = new int[matrix.length + 1][matrix[0].length + 1];
			for (int r = 0; r < matrix.length; r++) {
				for (int c = 0; c < matrix[r].length; c++) {
					dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
				}
			}
		}
		
		public int sumRegion(int row1, int col1, int row2, int col2) {
			return dp[row2 + 1][col2 + 1] - dp[row1][col2 +1 ] - dp[row2+1][col1] + dp[row1][col1];
		}
	}
	
	// https://leetcode.com/problems/range-sum-query-2d-mutable/description/
	private static class BinaryIndexTree {
		private int[][] sTree;
		private int rows;
		private int cols;
		private int[][] matrix;

		public BinaryIndexTree(int[][] matrix) {
			this.matrix = new int[matrix.length][matrix[0].length];
			this.rows = matrix.length;
			this.cols = matrix[0].length;
			this.sTree = new int[rows + 1][cols + 1];
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					update(row, col, matrix[row][col]);
				}
			}
			Arrays.stream(this.sTree).map(Arrays::toString).forEach(System.out::println);
		}

		private void update(int row, int col, int val) {
			if (rows == 0 || cols == 0)
				return;
			int delta = val - this.matrix[row][col];
			this.matrix[row][col] = val;
			for (int i = row + 1; i <= rows; i += i & (-i)) {
				for (int j = col + 1; j <= cols; j += j & (-j)) {
					this.sTree[i][j] += delta;
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (rows == 0 || cols == 0)
				return 0;
			return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
		}

		private int sum(int row, int col) {
			int sum = 0;
			for (int i = row; i > 0; i -= (i & (-i))) {
				for (int j = col; j > 0; j -= (i & (-i))) {
					sum += this.sTree[i][j];
				}
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		BruteForce bruteForce = new BruteForce(matrix.clone());
		System.out.println(bruteForce.sumRegion(2, 1, 4, 3));
		System.out.println(bruteForce.sumRegion(1, 1, 2, 2));
		System.out.println(bruteForce.sumRegion(1, 2, 2, 4));

		CumulativeSumRowCaching cumulativeSum = new CumulativeSumRowCaching(matrix.clone());
		System.out.println(cumulativeSum.sumRegion(2, 1, 4, 3));
		System.out.println(cumulativeSum.sumRegion(1, 1, 2, 2));
		System.out.println(cumulativeSum.sumRegion(1, 2, 2, 4));
		
		CumulativeSum2D sum2d = new CumulativeSum2D(matrix.clone());
		System.out.println(sum2d.sumRegion(2, 1, 4, 3));
		System.out.println(sum2d.sumRegion(1, 1, 2, 2));
		System.out.println(sum2d.sumRegion(1, 2, 2, 4));
		
		BinaryIndexTree binaryIndexTree = new BinaryIndexTree(matrix.clone());
		System.out.println(binaryIndexTree.sumRegion(2, 1, 4, 3));
		System.out.println(binaryIndexTree.sumRegion(1, 1, 2, 2));
		System.out.println(binaryIndexTree.sumRegion(1, 2, 2, 4));
	}

}
