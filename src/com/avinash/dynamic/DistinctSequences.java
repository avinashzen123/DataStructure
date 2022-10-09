package com.avinash.dynamic;

import java.util.Arrays;

public class DistinctSequences {
	// https://leetcode.com/problems/distinct-subsequences/
	//https://www.youtube.com/watch?v=9yV6Elqvblw
	public static int numDistinct(String s, String t) {
		int[][] table = new int[s.length() + 1][t.length() + 1];
		Arrays.stream(table).forEach(ar -> Arrays.fill(ar, -1));
//        Arrays.fill(table[0], 1);
		return dfs(s, t, table, 0, 0);
	}

	private static int dfs(String s, String t, int[][] table, int row, int col) {
		if (col >= t.length())
			return 1;
		if (row >= s.length())
			return 0;
		if (table[row][col] != -1) {
			return table[row][col];
		}
		if (s.charAt(row) == t.charAt(col)) {
			table[row][col] = dfs(s, t, table, row + 1, col + 1) + dfs(s, t, table, row + 1, col);
		} else {
			table[row][col] = dfs(s, t, table, row + 1, col);
		}
		return table[row][col];
	}

	//Not working
	public static int numDistinct1(String s, String t) {
		int[][] table = new int[s.length() + 1][t.length() + 1];
		Arrays.fill(table[0], 1);
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					table[i+1][j+1] = table[i][j] + table[i+1][j];
				} else {
					table[i][j] = table[i+1][j];
				}
			}
		}
		Arrays.stream(table).map(Arrays::toString).forEach(System.out::println);
//		return dfs1(s, t, table, 0, 0);
		return table[s.length()][t.length()];
	}

//	private static int dfs1(String s, String t, int[][] table, int row, int col) {
//		if (row >= 0 )
//		return 0;
//	}

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}

}
