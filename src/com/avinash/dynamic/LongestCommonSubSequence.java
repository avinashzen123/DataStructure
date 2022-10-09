package com.avinash.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubSequence {
	
	// Time complexity O(2*n) if n == m 
	public static int lcsRecursion(String s1, String s2) {
		return lcsRecursion(s1, s2, s1.length(), s2.length());
	}
	private static int lcsRecursion(String s1, String s2, int m, int n) {
		//We keep decrementing m and n
		//This is the base case for recursion
		if (m == 0 || n == 0) {
			return 0;
		}
		if (s1.charAt(m-1) == s2.charAt(n - 1)) {
			return 1 + lcsRecursion(s1, s2, m-1, n-1);
		} else {
			return Math.max(lcsRecursion(s1, s2, m, n-1), lcsRecursion(s1, s2, m-1, n));
		}
	}
	
	public static String lcsDynamicProgramming(String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		String lcs = "";
		int i = s1.length();
		int j = s2.length();
		while(i > 0 && j > 0) {
			//if the current character of S1 and S2 are matching then character is part of LCS
			if (s1.charAt(i-1) == s2.charAt(j-1)) {
				lcs += s2.charAt(j-1);
				i--;
				j--;
			} else if(dp[i-1][j] > dp[i][j-1]) {
				//If letter is not matching then find the larger of two and take step in the 
				//The direction of larger value.
				i--;
			} else {
				j--;
			}
		}
		return new StringBuffer(lcs).reverse().toString();
	}
	
	public  static List<Character> longestCommonSubsequence(String str1, String str2) {
	    // Write your code here.
	    int[][] table = new int[str1.length() + 1][str2.length() + 1];
	    for (int row = 1; row <= str1.length(); row++) {
	      for (int col = 1; col <= str2.length(); col++) {
	        if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
	          table[row][col] = 1 + table[row - 1][col - 1];
	        } else {
	          table[row][col] = Math.max(table[row - 1][col], table[row][col - 1]);
	        }
	      }
	    }
	    char[] result = new char[table[str1.length()][str2.length()]];
	    int resultIdx = result.length - 1;
	    int row = str1.length();
	    int col = str2.length();
	    while (row > 0 && col > 0) {
	      if (str1.charAt(row-1) == str2.charAt(col-1)) {
	        result[resultIdx--] = str1.charAt(row-1);
	        row --;
	        col --;
	      } else if (table[row - 1][col] > table[row][col - 1]) {
	        row --;
	      } else {
	        col --;
	      }
	    }
	    System.out.println(Arrays.toString(result));
	    return new ArrayList<Character>();
	  }
	
	public static void main(String[] args) {
		System.out.println("LCS is : " + lcsDynamicProgramming("abcd", "rtbxxxd"));
		System.out.println("LCS is : " + longestCommonSubsequence("abcd", "rtbxxxd"));
		
		System.out.println("LCS is : " + lcsRecursion("abcd", "rtbxxxd"));
	}
}
