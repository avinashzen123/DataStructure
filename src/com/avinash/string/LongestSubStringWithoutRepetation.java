package com.avinash.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepetation {

	public static String longestSubstringWithoutDuplication(String str) {
		Map<Character, Integer> lastSeen = new HashMap<>();
		int[] longest = {0, 1};
		int startIdx = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// If character is already seen the move startIdx to next pointer where it won't be duplicated
			if (lastSeen.containsKey(ch)) {
				startIdx = Math.max(startIdx, lastSeen.get(ch) + 1);
			}
			// Every iteration check if it is a longest substring
			if (longest[1] - longest[0] < i - startIdx + 1) {
				longest[0] = startIdx;
				longest[1] = i + 1;
			}
			lastSeen.put(ch, i);
		}
		return str.substring(longest[0], longest[1]);
	}
	public static void main(String[] args) {
		System.out.println(longestSubstringWithoutDuplication("clementisacap"));
		System.out.println(longestSubstringWithoutDuplication("abacaaaeaaafa"));
		System.out.println(longestSubstringWithoutDuplication("abcbde"));
		System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));
		System.out.println(longestSubstringWithoutDuplication("abccdeaabbcddef"));// Not working
		
		System.out.println(longestSubstringWithoutDuplication("abccdeaabbcddef"));
	}
}
