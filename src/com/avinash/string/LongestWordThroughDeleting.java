package com.avinash.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
public class LongestWordThroughDeleting {
	// Time complexity : O(2 ^ n)
	static class BruteForce {
		static String findLongestWord(String s, List<String> dictionary) {
			HashSet<String> set = new HashSet<>(dictionary);
			List<String> l = new ArrayList<>();
			generate(s, "", 0, l);
			String maxStr = "";
			for (String str : l) {
				if (set.contains(str)) {
					if (str.length() > maxStr.length() || (str.length() == maxStr.length() && str.compareTo(maxStr) < 0)) {
						maxStr = str;
					}
				}
			}
			return maxStr;
		}
		
		static void generate(String s, String str, int i, List<String> l) {
			if (i == s.length()) {
				l.add(str);
			} else {
				generate(s, str + s.charAt(i), i + 1, l);
				generate(s, str, i + 1, l);
			}
		}
	}
	
	static class IterativeBruteForce {
		// Time complexity: O(n ^ 2)
		static String findLongestWord(String s, List<String> dictionary) {
			HashSet<String> set = new HashSet<>(dictionary);
			List<String> list = new ArrayList<>();
			for (int i = 0; i < 1 << s.length(); i++) {
				String t = "";
				for (int j = 0; j < s.length();j++) {
					System.out.println("((i >> j) & 1) " + ((i >> j)) + " " + ((i >> j) & 1));
					if (((i >> j) & 1) != 0) {
						t+= s.charAt(j);
					}
				}
				list.add(t);
			}
			String maxStr = "";
			for (String str : list) {
				if (set.contains(str)) {
					if (str.length() > maxStr.length() || (str.length() == maxStr.length() && str.compareTo(maxStr) < 0)) {
						maxStr = str;
					}
				}
			}
			return maxStr;
		}
	}
	
	static class SortingAndCheckingSubSequence {
		// Time comlexity : O(n * xlog n + n + x)
		static boolean isSubSequence(String x, String y) {
			int j = 0;
			for (int i = 0; i < y.length() && j < x.length(); i++) {
				if (x.charAt(j) == y.charAt(i)) {
					j++;
				}
			}
			return j == x.length();
		}
		
		static String findLongestWord(String s, List<String> dictionary) {
			Collections.sort(dictionary, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s1.length() != s2.length()  ? s2.length() - s1.length() : s1.compareTo(s2);
				}
			});
			for (String str : dictionary) {
				if (isSubSequence(str, s)) {
					return str;
				}
			}
			return "";
		}
	}
	
	static class WithoutSorting {
		static String findLongestWord (String s, List<String> dictionary ) {
			String maxStr = "";
			for (String str: dictionary) {
				if (isSubSequence(str, s)) {
					if (str.length() > maxStr.length() || (str.length() == maxStr.length() && str.compareTo(maxStr) < 0)) {
						maxStr = str;
					}
				}
			}
			return maxStr;
		}
		// Time complexity : O(n. x)
		
		static boolean isSubSequence(String x, String y) {
			int j = 0;
			for (int i = 0; i < y.length() && j < x.length(); i++) {
				if (x.charAt(j) == y.charAt(i)) {
					j++;
				}
			}
			return j == x.length();
		}
	}
	public static void main(String[] args) {
		System.out.println(WithoutSorting.findLongestWord("abpcplea", new ArrayList<>(List.of("ale","apple","monkey","plea"))));
	}
}
