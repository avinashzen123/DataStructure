package com.avinash.dynamic;

// https://leetcode.com/problems/regular-expression-matching/solution/
public class RegularExpressionMatch {
	public static boolean isMatchRecursive(String s, String p) {
		if (s.length() == 0 && p.length() == 0) {
			return true;
		}

		return dfs(s, 0, p, 0);
	}

	private static boolean dfs(String str, int strIndex, String pattern, int patternIndex) {
		if (str.length() <= strIndex && pattern.length() <= patternIndex) {
			return true;
		}
		if (pattern.length() <= patternIndex) {
			return false;
		}
		if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
			return dfs(str, strIndex, pattern, patternIndex + 2) || ((strIndex < str.length()
					&& (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.'))
					&& dfs(str, strIndex + 1, pattern, patternIndex));
		}
		if (strIndex < str.length()
				&& (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.')) {
			return dfs(str, strIndex + 1, pattern, patternIndex + 1);
		}
		return false;
	}

	public static boolean matchRegularExpressionTopDown(String text, String pattern, int textIndex, int patternIndex,
			boolean[][] memo) {
		if (memo[textIndex][patternIndex]) {
			System.out.println("Returning from cache");
			return true;
		}
		boolean ans = false;
		if (patternIndex == pattern.length() && textIndex == text.length()) {
			ans = true;
		} else {
			boolean firstMatch = (textIndex < text.length()
					&& (pattern.charAt(patternIndex) == text.charAt(textIndex) || pattern.charAt(patternIndex) == '.'));
			if (patternIndex <= pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
				ans = (matchRegularExpressionTopDown(text, pattern, textIndex, patternIndex + 2, memo)) || (firstMatch
						&& matchRegularExpressionTopDown(text, pattern, textIndex + 1, patternIndex, memo));
			} else {
				ans = firstMatch && matchRegularExpressionTopDown(text, pattern, textIndex + 1, patternIndex + 1, memo);
			}
		}
		memo[textIndex][patternIndex] = ans;
		return ans;
	}
	// Working
	public static boolean matchRegularExpressionBottomUp(String text, String pattern) {
		boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
		dp[text.length()][pattern.length()] = true;
		for (int i = text.length(); i >=0; i--) {
			for (int j = pattern.length() - 1; j >= 0 ; j--) {
				boolean firstMatch = (i < text.length()) && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');
				if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*'){
					dp[i][j] = dp[i][j+2] || (firstMatch && dp[+1][j]);
				} else {
					dp[j][j] = firstMatch && dp[i+1][j+1];
				}
			}
		}
		return dp[0][0];
	}

	//
	public static boolean matchRegularExpressionDP(char[] text, char[] pattern) {
		boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

		T[0][0] = true;
		// To deal with pattern like a* or a*b* or a*b*c*
		for (int i = 1; i < T[0].length; i++) {
			if (pattern[i - 1] == '*') {
				T[0][i] = T[0][i - 2];
			}
		}
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[i - 1] == '.' || pattern[j - 1] == text[i - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[i - 1] == '*') {
					T[i][j] = j >= 2 ? T[i][j - 2] : false;// Not considering current Character
					if ((j > 2 && pattern[j - 2] == text[i - 1]) || (j >= 2 && pattern[j - 2] == '.')) {
						T[i][j] = T[i][j] || T[i - 1][j];
					}
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[text.length][pattern.length];
	}

	public static void main(String[] args) {
//		System.out.println(isMatchRecursive("aab", "c*a*b"));
		System.out.println(isMatchRecursive("aa", "a*"));
		System.out.println(isMatchRecursive("ab", ".*c"));
		System.out.println(matchRegularExpressionDP("ab".toCharArray(), ".*c".toCharArray()));
		System.out.println(matchRegularExpressionDP("aa".toCharArray(), "a*".toCharArray()));

		System.out.println(matchRegularExpressionTopDown("aa", "a*", "aa".length(),
				"a*".length(), new boolean["aa".length() + 1]["a*".length() + 1]));
		
		System.out.println(matchRegularExpressionBottomUp("ab", ".*c"));
	}

}
