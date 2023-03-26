package com.avinash.string;

// https://leetcode.com/problems/one-edit-distance/
/**
 * Given two strings s and t, return true if they are both one edit distance
 * apart, otherwise return false.
 * 
 * A string s is said to be one distance apart from a string t if you can:
 * 
 * Insert exactly one character into s to get t. Delete exactly one character
 * from s to get t. Replace exactly one character of s with a different
 * character to get t.
 * 
 * Input: s = "ab", t = "acb"
 * 
 * Output: true
 * 
 * Explanation: We can insert 'c' into s to get t.
 *
 * Input: s = "", t = ""
 * 
 * Output: false
 * 
 * Explanation: We cannot get t from s by only one step.
 */
public class OneEditDistance {
	static class OnePassAlgorithm {
		static boolean isOneEditDistance(String s, String t) {
			int sLen = s.length();
			int tLen = t.length();
			if (sLen > tLen) {
				return isOneEditDistance(t, s);
			}
			if (sLen - tLen > 1) {
				return false;
			}
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					if (sLen == tLen) {
						return s.substring(i + 1).equals(t.substring(i + 1));
					} else {
						return s.substring(i).equals(t.substring(i + 1));
					}
				}
			}
			return (sLen + 1 == tLen);
		}
	}

	public static void main(String[] args) {
		System.out.println(OnePassAlgorithm.isOneEditDistance("ab", "acb"));
		System.out.println(OnePassAlgorithm.isOneEditDistance("a", ""));
	}
}
