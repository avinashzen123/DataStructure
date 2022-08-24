package com.avinash.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinEditDistance {

	public static int minEditDistance(String str1, String str2) {
		int[][] dpTable = new int[str1.length()+1][str2.length() + 1];
		IntStream.range(0, str1.length() + 1).forEach(i -> dpTable[str1.length()][i] = str1.length() - i);
		IntStream.range(0, str2.length() + 1).forEach(i -> dpTable[i][str2.length()] = str2.length() - i);
		for (int row = str1.length()-1; row >=0 ; row--) {
			for (int col = str2.length() - 1; col >= 0; col--) {
				if (str1.charAt(row) == str2.charAt(col)) {
					dpTable[row][col] = dpTable[row+1][col+1];
				} else {
					dpTable[row][col] = 1 + Math.min(dpTable[row+1][col], Math.min(dpTable[row][col+1], dpTable[row+1][col+1]));
				}
			}
		}
		Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
		return dpTable[0][0];
	}
	
	public static void main(String[] args) {
		System.out.println(minEditDistance("abc", "adc"));
	}
}
