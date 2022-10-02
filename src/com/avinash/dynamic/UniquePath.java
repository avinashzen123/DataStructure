package com.avinash.dynamic;

import java.util.Arrays;

public class UniquePath {
	public int uniquePaths(int m, int n) {
		int[] row = new int[n];
		Arrays.fill(row, 1);
		for (int i = m; i > 1; i --) {
			int[] newRow = new int[n];
			newRow[n-1] = 1;
			for (int j = n - 2; j >= 0; j--) {
				newRow[j] = newRow[j + 1] + row[j];
			}
			row = newRow;
		}
		return row[0];
	}
	
	public static void main(String[] args) {
		System.out.println(new UniquePath().uniquePaths(3, 7));
	}
}
