package com.avinash.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/
/**
 * 
 * Given a string s, return the number of unique palindromes of length three
 * that are a subsequence of s.
 * 
 * Note that even if there are multiple ways to obtain the same subsequence, it
 * is still only counted once.
 * 
 * A palindrome is a string that reads the same forwards and backwards.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * Input: s = "aabca"
 * 
 * Output: 3
 * 
 * Explanation: The 3 palindromic subsequences of length 3 are:
 * 
 * - "aba" (subsequence of "aabca") 
 * - "aaa" (subsequence of "aabca") 
 * - "aca" (subsequence of "aabca")
 *
 */
public class UniqueLength3Pallindrom {
	public int countPalindromicSubsequence(String s) {
		Set<Character> left = new HashSet<>();
		Map<Character, Integer> right = new HashMap<>();
		for (Character ch : s.toCharArray()) {
			right.put(ch, right.getOrDefault(ch, 0) + 1);
		}
		Set<String> result = new HashSet<>();
		for (int mid = 0; mid < s.length(); mid++) {
			Character ch = s.charAt(mid);
			right.put(ch, right.get(ch) - 1);
			if (right.get(ch) == 0) {
				right.remove(ch);
			}
			for (int i = 0; i < 26; i++) {
				char letter = (char) (i + 'a');
				if (left.contains(letter) && right.containsKey(letter)) {
					result.add("" + letter + ch + letter);
				}
			}
			left.add(ch);
		}
		System.out.println(result);
		return result.size();
	}

	public static void main(String[] args) {
		UniqueLength3Pallindrom pallindrom = new UniqueLength3Pallindrom();
		System.out.println(pallindrom.countPalindromicSubsequence("aabca"));
	}
}
