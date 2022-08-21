package com.avinash.dynamic;

import java.util.stream.IntStream;

public class SubsetSumProblem {
	private boolean[][] s;
	private int[] nums;
	private int m;

	public SubsetSumProblem(int[] nums, int m) {
		this.nums = nums;
		this.m = m;
		this.s = new boolean[nums.length + 1][m + 1];
	}

	public void solve() {
		// First column contains True values.
		// If 'm' is 0 then we can make the empty subset to make sum 0
		IntStream.range(0, nums.length).forEach(i -> s[i][0] = true);
		// WE consider all N+1 rows and M+1 columns
		for (int rowIndex = 1; rowIndex < nums.length + 1; rowIndex++) {
			for (int colIndex = 1; colIndex < m + 1; colIndex++) {
				// if the colIndex is small the we have to copy value from cell above.
				if (colIndex < nums[rowIndex - 1]) {
					// s[i-1][j - arr[i-1]] can give index out of bound exception because of j -
					// arr[i-1]
					s[rowIndex][colIndex] = s[rowIndex - 1][colIndex];
				} else {
					if (s[rowIndex - 1][colIndex]) {
						// We do not include give item
						s[rowIndex][colIndex] = s[rowIndex - 1][colIndex];
					} else {
						// We include the item with rowIndex
						s[rowIndex][colIndex] = s[rowIndex - 1][colIndex - nums[rowIndex - 1]];
					}
				}
			}
		}
	}

	public void showResult() {
		System.out.println("There is a feasible solution : " + s[nums.length][m]);
//		Arrays.stream(s).map(Arrays::toString).forEach(System.out::println);;
		if (s[nums.length][m]) {
			int colIndex = this.m;
			int rowIndex = this.nums.length;
			while (rowIndex > 0 && colIndex > 0) {
				if (s[rowIndex][colIndex] == s[rowIndex - 1][colIndex]) {
					rowIndex = rowIndex - 1;
				} else {
					System.out.println("We take item : " + nums[rowIndex - 1]);
					colIndex = colIndex - nums[rowIndex - 1];
					rowIndex--;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 7, 4, 3, 6, 5, 9, 11};
		int m = 43;
		SubsetSumProblem problem = new SubsetSumProblem(array, m);
		problem.solve();
		problem.showResult();
	}
}
