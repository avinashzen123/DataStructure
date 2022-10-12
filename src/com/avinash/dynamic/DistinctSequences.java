package com.avinash.dynamic;

import java.util.Arrays;

public class DistinctSequences {
	// https://leetcode.com/problems/distinct-subsequences/
	// https://www.youtube.com/watch?v=9yV6Elqvblw
	/*
	 * Given two strings s and t, return the number of distinct subsequences of s
	 * which equals t.
	 * 
	 * A string's subsequence is a new string formed from the original string by
	 * deleting some (can be none) of the characters without disturbing the
	 * remaining characters' relative positions. (i.e., "ACE" is a subsequence of
	 * "ABCDE" while "AEC" is not).
	 * 
	 * The test cases are generated so that the answer fits on a 32-bit signed
	 * integer.
	 * 
	 * 
	 * Input: s = "rabbbit", t = "rabbit" Output: 3 Explanation: As shown below,
	 * there are 3 ways you can generate "rabbit" from s. rabbbit rabbbit rabbbit
	 * 
	 */
	public static int numDistinct(String s, String t) {
		int[][] table = new int[s.length() + 1][t.length() + 1];
		Arrays.stream(table).forEach(ar -> Arrays.fill(ar, -1));
//        Arrays.fill(table[0], 1);
		int dfs = dfs(s, t, table, 0, 0);
		Arrays.stream(table).map(Arrays::toString).forEach(System.out::println);
		return dfs;
	}

	private static int dfs(String s, String t, int[][] table, int sIndex, int tIndex) {
		if (tIndex >= t.length())
			return 1;
		if (sIndex >= s.length())
			return 0;
		if (table[sIndex][tIndex] != -1) {
			return table[sIndex][tIndex];
		}
		if (s.charAt(sIndex) == t.charAt(tIndex)) {
			table[sIndex][tIndex] = dfs(s, t, table, sIndex + 1, tIndex + 1) + dfs(s, t, table, sIndex + 1, tIndex);
		} else {
			table[sIndex][tIndex] = dfs(s, t, table, sIndex + 1, tIndex);
		}
		return table[sIndex][tIndex];
	}

//	//Not working
//	public static int numDistinct1(String s, String t) {
//		int[][] table = new int[s.length() + 1][t.length() + 1];
//		Arrays.fill(table[0], 1);
//		for (int i = 1; i <= s.length(); i++) {
//			for (int j = 1; j <= t.length(); j++) {
//				if (s.charAt(i-1) == t.charAt(j-1)) {
//					table[i+1][j+1] = table[i][j] + table[i+1][j];
//				} else {
//					table[i][j] = table[i+1][j];
//				}
//			}
//		}
//		Arrays.stream(table).map(Arrays::toString).forEach(System.out::println);
////		return dfs1(s, t, table, 0, 0);
//		return table[s.length()][t.length()];
//	}

//	private static int dfs1(String s, String t, int[][] table, int row, int col) {
//		if (row >= 0 )
//		return 0;
//	}

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
//		System.out.println(numDistinct("ra", "ra"));
	}

}
