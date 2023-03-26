package com.avinash.dynamic;

// https://leetcode.com/problems/minimum-falling-path-sum/description/
public class MinFallingPathSum {
	static class BrutreForce {
		/*
		 * Time complexity : O(N. 3 ^ N)
		 */
		static int minFallingPathSum(int[][] matrix) {
			int minFallingPathSum = Integer.MAX_VALUE;
			for (int startCol = 0; startCol < matrix.length; startCol++) {
				minFallingPathSum = Math.min(minFallingPathSum, findMinFallingPathSum(matrix, 0, startCol));
			}
			return minFallingPathSum;
		}

		static int findMinFallingPathSum(int[][] matrix, int row, int col) {
			if (col < 0  || col == matrix.length) {
				return Integer.MAX_VALUE;
			}
			if (row == matrix.length - 1) {
				return matrix[row][col];
			}
			int left = findMinFallingPathSum(matrix, row + 1, col);
			int middle = findMinFallingPathSum(matrix, row + 1, col + 1);
			int right = findMinFallingPathSum(matrix, row + 1, col - 1);
			return Math.min(left, Math.min(middle, right)) + matrix[row][col];
		}	
	}
	
	static class DynamicProgrammingTopDown {
		/**
		 * Time Complexity : O (N ^ 2)
		 */
		static int minfallingPathSum(int[][] matrix) {
			int minFallingSum = Integer.MAX_VALUE;
			Integer[][] memo = new Integer[matrix.length][matrix[0].length];
			
			for (int startCol = 0; startCol < matrix.length; startCol++) {
				minFallingSum = Math.min(minFallingSum, findMinFallingPathSum(matrix, 0, startCol, memo));
			}
			return minFallingSum;
		}

		private static int findMinFallingPathSum(int[][] matrix, int row, int col, Integer[][] memo) {
			if (col < 0 || col == matrix.length) {
				return Integer.MAX_VALUE;
			}
			if (row == matrix.length - 1) {
				return matrix[row][col];
			}
			if (memo[row][col] != null) {
				return memo[row][col];
			}
			int left = findMinFallingPathSum(matrix, row + 1, col, memo);
			int middle = findMinFallingPathSum(matrix, row + 1, col + 1, memo);
			int right = findMinFallingPathSum(matrix, row + 1, col - 1, memo);	        
	        memo[row][col] = Math.min(left, Math.min(middle, right)) + matrix[row][col];
			return memo[row][col];
		}
	}
	
	static class DynamicProgrammingBottomUp {
		// Tabulation
		static int minFallingPathSum(int[][] matrix) {
			int dp[][] = new int[matrix.length + 1][matrix.length + 1];
			for (int row = matrix.length - 1; row >= 0; row--) {
				for (int col = 0; col < matrix.length; col++) {
					if (col == 0) {
						dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + matrix[row][col];
					} else if (col == matrix.length - 1) {
						dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col - 1]) + matrix[row][col];
					} else {
						dp[row][col] = Math.min(dp[row + 1][col + 1], dp[row + 1][col - 1]) + matrix[row][col];
					}
				}
			}
			int minFallingSum = Integer.MAX_VALUE;
			for (int startCol = 0; startCol < matrix.length; startCol++) {
				minFallingSum = Math.min(minFallingSum, dp[0][startCol]);
			}
			return minFallingSum;
		}
	}
	
	static class DynamicProgrammingBottomUpSpaceOptimized {
		static int minFallingPathSum(int[][] matrix) {
			int dp[] = new int[matrix.length + 1];
			for (int row = matrix.length - 1; row >= 0; row--) {
				int currentRow[] = new int[matrix.length + 1];
				for (int col = 0; col < matrix.length; col++) {
					if (col == 0) {
						currentRow[col] = Math.min(dp[col], dp[col + 1] + matrix[row][col]);
					} else if (col == matrix.length - 1) {
						currentRow[col] = Math.min(dp[col], dp[col + 1]) + matrix[row][col];
					} else {
						currentRow[col] = Math.min(dp[col + 1], dp[col - 1]) + matrix[row][col];
					}
				}
			}
			int minFallingSum = Integer.MAX_VALUE;
			for (int startCol = 0; startCol < matrix.length; startCol ++) {
				minFallingSum = Math.min(minFallingSum, dp[startCol]);
			}
			return minFallingSum;
		}
	}
	
	public static void main(String[] args) {
		int[][] array = {{2,1,3},{6,5,4},{7,8,9}};
		System.out.println(BrutreForce.minFallingPathSum(array));
		System.out.println(DynamicProgrammingTopDown.minfallingPathSum(array));
		System.out.println(DynamicProgrammingBottomUp.minFallingPathSum(array));
	}
}
