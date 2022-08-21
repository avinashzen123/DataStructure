package com.avinash.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Define a 2-dimension array "table" and let table[i][j] denote whether
 * substring from i to j is palindrome. Start condition: table[i][i] == 1;
 * table[i][i+1] == 1 => s.charAt(i) == s.charAt(i+1) Changing condition:
 * table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j) => table[i][j] == 1 Time
 * O(nˆ2) Space O(nˆ2)
 * 
 * @author LENOVO
 *
 */
public class LongestPallindrome {
	public static String longestPallindrome(String s) {
		int n = s.length();
		boolean table[][] = new boolean[n][n];
		int maxLenth = 1;
		int start = 0;
		IntStream.range(0, n).forEach(i -> table[i][i] = true);
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLenth = 2;
			}
		}
		for (int length = 3; length <= n; length++) {
			for (int row = 0; row < n - length + 1; row++) {
				int column =	 row + length - 1;
				if (table[row + 1][column - 1] && s.charAt(row) == s.charAt(column)) {
					table[row][column] = true;
					if (length > maxLenth) {
						start = row;
						maxLenth = length;
					}
				}
			}
		}
		System.out.println("Max length " + maxLenth + " " + start);
		return s.substring(start, start + maxLenth);
	}

	public static void printTable(boolean[][] x, String str) {
		for (boolean[] y : x) {
			for (boolean z : y) {	
				System.out.print(z + " ,  ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

	public static void main(String[] args) {

		String str = "forgeeksskeegfor";
		System.out.println("Length is: " + longestPallindrome(str));
		System.out.println("Length is: " + longestPallindrome("babad"));

		System.out.println("Length is: " + longestPallindrome("cbbd"));
		
		System.out.println("Length is: " + longestPallindrome("ccc"));
		
	}
}
