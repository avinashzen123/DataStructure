package com.avinash.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/ Given a
 * string s, partition s such that every substring of the partition is a
 * palindrome . Return all possible palindrome partitioning of s.
 * 
 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]]
 * 
 */
public class PartitionPallindrom {
	static class BackTracking {
		public List<List<String>> partition(String s) {
			List<List<String>> result = new ArrayList<>();
			dfs(0, result, new ArrayList<>(), s);
			return result;
		}

		private void dfs(int start, List<List<String>> result, ArrayList<String> currList, String s) {
			if (start >= s.length())
				result.add(new ArrayList<>(currList));
			for (int end = start; end < s.length(); end++) {
				if (isPallindrom(s, start, end)) {
					currList.add(s.substring(start, end + 1));
					dfs(end + 1, result, currList, s);
					currList.remove(s.subSequence(start, end + 1));
				}
			}
		}

		private boolean isPallindrom(String s, int start, int end) {
			while (start < end) {
				if (s.charAt(start++) != s.charAt(end--))
					return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(new BackTracking().partition("aaab"));
	}
}
