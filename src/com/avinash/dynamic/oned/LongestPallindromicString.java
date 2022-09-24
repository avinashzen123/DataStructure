package com.avinash.dynamic.oned;

import java.util.Arrays;

public class LongestPallindromicString {

	public static String longestPallindrome(String s) {
		if (s.length() < 2) return s;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			int left = i, right = i;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				if (right - left - 1 > result.length()) {
					result = s.substring(left, right + 1);
				}
				left--;
				right++;
			}
			left = i;
			right = i+1;
			while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				if (right - left + 1 > result.length()) {
					result = s.substring(left, right + 1);
				}
				left --;
				right ++;
			}
		}
		return result;
	}
	
	public static String longestPallindromeDP(String s) {
		boolean isPallindrome[][] = new boolean[s.length()][s.length()];
		int max = 0;
		int left = 0;
		int right = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (i == j) {
					isPallindrome[i][j] = true;
				} else if (s.charAt(i) == s.charAt(j)) {
					if (j - i == 1) {
						isPallindrome[i][j] = true;
					} else {
						isPallindrome[i][j] = isPallindrome[i + 1][j - 1];
					}
				}
				if (isPallindrome[i][j] && j - i + 1 > max) {
					max = j - i + 1;
					left = i;
					right = j + 1;
				}
			}
		}
		Arrays.stream(isPallindrome).map(Arrays::toString).forEach(System.out::println);
		return s.substring(left, right);
	}
	
	public static void main(String[] args) {
		System.out.println(longestPallindrome("babad"));
		System.out.println(longestPallindromeDP("babad"));
		
//		System.out.println(longestPallindrome("cbbd"));
//		System.out.println(longestPallindromeDP("cbbd"));
	}
}
