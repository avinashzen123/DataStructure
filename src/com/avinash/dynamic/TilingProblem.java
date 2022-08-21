package com.avinash.dynamic;

public class TilingProblem {
	public static int solve(int n) {
		return solve(n, new int[n]);
	}
	private static int solve(int n, int[] table) {
		System.out.println("Execution");
		if (n <= 2)
			return n;
		if (table[n-1] != 0) return table[n-1];
		table[n-1] = solve(n-1, table) + solve(n-2, table);
		return table[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(solve(4));
		System.out.println(solve(3));
	}
}
