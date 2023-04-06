package com.avinash.dynamic;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle/description/
/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 * 
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		Arrays.stream(memo).forEach(o -> Arrays.fill(o, Integer.MAX_VALUE));
		return recurse(triangle, 0, 0, memo);
	}

	private int recurse(List<List<Integer>> triangle, int row, int col, int[][] memo) {
		if (row == triangle.size())
			return 0;
		if (memo[row][col] != Integer.MAX_VALUE)
			return memo[row][col];
		int rem = Math.min(recurse(triangle, row + 1, col, memo), recurse(triangle, row + 1, col + 1, memo));
		return memo[row][col] = triangle.get(row).get(col) + rem;
	}
}
