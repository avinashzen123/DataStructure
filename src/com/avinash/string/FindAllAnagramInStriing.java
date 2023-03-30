package com.avinash.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
/**
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Input: s = "cbaebabacd", p = "abc"
 * 
 * Output: [0,6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 *
 */
public class FindAllAnagramInStriing {
	static List<Integer> findAnagrams(String str, String patt) {
		int ns = str.length();
		int np = patt.length();
		if (ns < np)
			return new ArrayList<>();

		Map<Character, Integer> pCount = new HashMap<>();
		Map<Character, Integer> sCount = new HashMap<>();
		List<Integer> output = new ArrayList<>();

		for (char ch : patt.toCharArray()) {
			pCount.put(ch, pCount.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < ns; i++) {
			char ch = str.charAt(i);
			sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);

			// Remove one letter from left side of window
			if (i >= np) {
				ch = str.charAt(i - np);
				if (sCount.get(ch) == 1)
					sCount.remove(ch);
				else
					sCount.put(ch, sCount.get(ch) - 1);
			}
			// Compare hashmap in sliding window with reference hashMap
			if (pCount.equals(sCount)) {
				output.add(i - np + 1);
			}
		}

		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}
}
