package com.avinash.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinCost { 

	public static int minCost(String s, int[] c) {
		int[][] table = new int[s.length() + 1][s.length() + 1];
		for (int row = 1; row < table.length; row++) {
			for (int col = 2; col < table.length; col++) {
				if (col > 1 && s.charAt(row-1) == s.charAt(col-1) && s.charAt(col - 1) == s.charAt(col -2)) {
					table[row][col] = table[row-1][col-1] + Math.min(c[col-1],c[col-2]);
				}else {
					table[row][col] = Math.max(table[row][col-1], table[row-1][col]);
				}
			}
		}
		Arrays.stream(table).map(Arrays::toString).forEach(System.out::println);;
		return table[s.length()][s.length()];
	}
	
	public static void main(String[] args) {
		Set<Integer> collect = Arrays.stream(new int[] {}).boxed().collect(Collectors.toSet());
		collect.remove(1);
		System.out.println(collect.size());
		System.out.println(minCost("aabbcc", new int[] {1,2,1,2,1,2}));
	}
}
