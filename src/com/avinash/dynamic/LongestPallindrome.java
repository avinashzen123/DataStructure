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
	public static String longestPallindrome(String str) {
		int n = str.length();
		boolean table[][] = new boolean[n][n];
		int maxLenth = 1;
		int start = 0;
		IntStream.range(0, n).forEach(i -> table[i][i] = true);
		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLenth = 2;
			}
		}
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k - 1; i++) {
				int j = i + k - 1;
//				System.out.println(i + " " + j + " " + k + " " + table[i + 1][j - 1] + " " + str.charAt(i) + " "
//						+ str.charAt(j) + " i + 1, j -1  " + str.charAt(i + 1) + " " + str.charAt(j - 1));
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
//					printTable(table, str);
					table[i][j] = true;
					if (k > maxLenth) {
						start = i;
						maxLenth = k;
					}
				}
			}
		}
		System.out.println("Max length " + maxLenth + " " + start);
		return str.substring(start + 1, start + maxLenth - 1);
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
	}
}
