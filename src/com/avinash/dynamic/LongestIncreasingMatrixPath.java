package com.avinash.dynamic;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingMatrixPath {

	
	private static class Point {
		public int row;
		public int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public int hashCode() {
			return new String("" + row + ""+ col).hashCode();
		}
		
		public boolean equals(Object o) {
			Point p =(Point)o;
			return new String(""+ row+""+col).equals("" + p.row + "" + p.col);
		}
	}
	
	/*
	 * Given an m x n integers matrix, return the length of the longest increasing
	 * path in matrix.
	 * 
	 * From each cell, you can either move in four directions: left, right, up, or
	 * down. You may not move diagonally or move outside the boundary (i.e.,
	 * wrap-around is not allowed).
	 * 
	 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
	 * 
	 * Output: 4
	 * 
	 * Explanation: The longest increasing path is [1, 2, 6, 9].
	 * 
	 * 
	 */
	public static int longestIncreasingPath(int[][] matrix) {
		Map<Point, Integer> table = new HashMap<>();
		for (int row = 0; row < matrix.length; row ++) {
			for (int col = 0; col < matrix[row].length; col++) {
				longestIncreasingPath(matrix, table, new Point(row,col), -1);
			}
		}
		return table.values().stream().max((i, j) -> i - j).get();
	}
	
	private static int longestIncreasingPath(int[][] matrix, Map<Point, Integer> table, Point point, int prevValue) {
		if (point.row < 0 || point.row >= matrix.length || point.col < 0 || point.col >= matrix[point.row].length || matrix[point.row][point.col] <= prevValue) {
			return 0;
		}
		if (table.containsKey(point)) {
			return table.get(point);
		}
		int result = 1;
		result = Math.max(result, 1 + longestIncreasingPath(matrix, table, new Point(point.row + 1, point.col), matrix[point.row][point.col]));
		result = Math.max(result, 1 + longestIncreasingPath(matrix, table, new Point(point.row - 1, point.col), matrix[point.row][point.col]));
		result = Math.max(result, 1 + longestIncreasingPath(matrix, table, new Point(point.row, point.col + 1), matrix[point.row][point.col]));
		result = Math.max(result, 1 + longestIncreasingPath(matrix, table, new Point(point.row, point.col - 1), matrix[point.row][point.col]));
		table.put(point, result);
		return result;
	}

	public static void main(String[] args) {
//		int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
//		System.out.println(longestIncreasingPath(matrix));
		System.out.println(longestIncreasingPath(new int[][] {{9,9,4},{6,6,8},{2,1,1}}));
	}
}
