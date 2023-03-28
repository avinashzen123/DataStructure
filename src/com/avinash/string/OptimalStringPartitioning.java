package com.avinash.string;

import java.util.HashMap;
import java.util.Map;

public class OptimalStringPartitioning {

	/**
	 * <a href="https://leetcode.com/problems/optimal-partition-of-string/description/">Leet code</a>
	 * 
	 * Given a string s, partition the string into one or more substrings such that
	 * the characters in each substring are unique. That is, no letter appears in a
	 * single substring more than once.
	 * 
	 * Return the minimum number of substrings in such a partition.
	 * 
	 * Note that each character should belong to exactly one substring in a
	 * partition.
	 * 
	 * 
	 * Input: s = "abacaba" Output: 4 Explanation: Two possible partitions are
	 * ("a","ba","cab","a") and ("ab","a","ca","ba"). It can be shown that 4 is the
	 * minimum number of substrings needed.
	 * 
	 * Input: s = "ssssss" Output: 6 Explanation: The only valid partition is
	 * ("s","s","s","s","s","s").
	 * 
	 */

	public static int partitionString(String s) {
		Map<Character, Integer> dict = new HashMap<>();
		int ans = 1;
		for (int index = 0; index < s.length(); index++) {
			char c = s.charAt(index);
			if (dict.containsKey(c)) {
				ans++;
				dict.clear();
				dict.put(c, dict.getOrDefault(c, 0) + 1);
				System.out.println("Increased counter");
			} else {
				dict.put(c, dict.getOrDefault(c, 0) + 1);
			}
			System.out.println(dict);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(partitionString("abacaba"));
//		System.out.println(partitionString("ssssss"));
	}
}
