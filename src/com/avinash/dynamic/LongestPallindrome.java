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
				int column = row + length - 1;
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

	public static String longestPallindromeDP(String s) {
		boolean isPallindrome[][] = new boolean[s.length()][s.length()];
		int max = 0;
		int left = 0;
		int right = 1;
		for (int row = s.length() - 1; row >= 0; row--) {
			for (int col = row; col < s.length(); col++) {
				if (row == col) {
					isPallindrome[row][col] = true;
				} else if (s.charAt(row) == s.charAt(col)) {
					if (col - row == 1) {
						isPallindrome[row][col] = true;
					} else {
						isPallindrome[row][col] = isPallindrome[row + 1][col - 1];
					}
				}
				if (isPallindrome[row][col] && col - row + 1 > max) {
					max = col - row + 1;
					left = row;
					right = col + 1;
				}
			}
		}
//		Arrays.stream(isPallindrome).map(Arrays::toString).forEach(System.out::println);
		return s.substring(left, right);
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

//		String str = "forgeeksskeegfor";
//		System.out.println("Length is: " + longestPallindrome(str));
		System.out.println("Length is: " + longestPallindrome("babad"));
		
		System.out.println("Length is: " + longestPallindromeDP("z234a5abbbba54a32z"));

//		System.out.println("Length is: " + longestPallindrome("cbbd"));
//
//		System.out.println("Length is: " + longestPallindrome("ccc"));

	}
}
