package com.avinash.dynamic;


/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 * 
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * Input: s = "abc" Output: 3 Explanation: Three palindromic strings: "a", "b",
 * "c".
 * 
 * Input: s = "aaa" 
 * Output: 6 
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 */
public class FindPallindromicSubString {

	private static class BruteForce {
		private static boolean isPallindrom(String s, int start, int end) {
			while(start < end) {
				if (s.charAt(start) != s.charAt(end)) {
					return false;
				}
				start++;
				end--;
			}
			return true;
		}
		/**
		 * Time complexity : O(N^3)
		 */
		public static int countSubStrings(String s) {
			int ans = 0;
			for (int start = 0; start < s.length(); start++) {
				for (int end = start; end < s.length(); end++) {
					ans += isPallindrom(s, start, end) ? 1 : 0;
				}
			}
			return ans;
		}
	}
	
	private static class DP {
		/*
		 * time complexity : O(N^2)
		 */
		public static int countSubStrings (String s) {
			int n = s.length();
			int ans = 0;
			if (n <= 0) {
				return 0;
			}
			boolean[][] dp = new boolean[n][n];
			//Base case : Single letter substrings
			for (int i = 0;i < n; i++, ++ans) {
				dp[i][i] = true;
			}
			//Base case double letter substrings
			for (int i = 0; i < n - 1; i++) {
				dp[i][i+1] = (s.charAt(i) == s.charAt(i + 1));
				ans += (dp[i][i+1] ? 1 : 0);
			}
			// All other cases : substrings of lengths 3 to n
			for (int len = 3; len <= n; len++) {
				for (int i = 0, j = i + len - 1; j < n; j++, i++) {
					dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
					ans += (dp[i][j] ? 1 : 0);
				}
			}
			return ans;
		}
	}
	
	private static class ExpandAroundCentre {
		/*
		 * We can choose all possible centres for possible palindromes:
		 * 		Every single character in the string is a centre for 
		 * 		possible odd-length palindromes
		 * 
		 * 		Every pair of consecutive characters in the string is a
		 * 		centre for possible even-length palindromes
		 * 
		 * For every centre, we can expand around it as long as we get 
		 * palindrome 
		 */
		
		public static int countSubstrings(String s) {
			int ans = 0;
			for (int i = 0; i < s.length(); i++) {
				// Odd length palindromes, single character centre
				ans += countPallindromeAroundCentre(s, i, i);
				// Even length palindromes, consecuting character centre
				ans += countPallindromeAroundCentre(s, i, i  + 1);
			}
			return ans;
		}

		private static int countPallindromeAroundCentre(String s, int low, int high) {
			int ans = 0;
			while (low >= 0 && high < s.length()) {
				if (s.charAt(low) != s.charAt(high)) {
					break;
				}
				low --;
				high ++;
				ans++;
			}
			return ans;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(BruteForce.countSubStrings("aaa"));
		System.out.println(BruteForce.countSubStrings("abc"));
		
		System.out.println(DP.countSubStrings("aaa"));
		System.out.println(DP.countSubStrings("abc"));
		
		System.out.println(ExpandAroundCentre.countSubstrings("aaa"));
		System.out.println(ExpandAroundCentre.countSubstrings("abc"));
	}
}
