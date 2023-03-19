package com.avinash.string;

import java.util.HashSet;

// Longest Repeating Character Replacement
// https://www.youtube.com/watch?v=gqXU1UyA8pk&t=716s
//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {

	/*
	 * You are given a string s and an integer k. You can choose any character of
	 * the string and change it to any other uppercase English character. You can
	 * perform this operation at most k times.
	 * 
	 * Return the length of the longest substring containing the same letter you can
	 * get after performing the above operations.
	 * 
	 * Input: s = "ABAB", k = 2 Output: 4
	 * 
	 * Explanation: Replace the two 'A's with two 'B's or vice versa.
	 * 
	 * Input: s = "AABABBA", k = 1 Output: 4
	 * 
	 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
	 * The substring "BBBB" has the longest repeating letters, which is 4.
	 * 
	 * Time Complexity : O(n)
	 */
	public static int repetingCharacterReplacement(String str, int k) {
		int[] frequency = new int[26];
		int left = 0;
		int result = 0;
		int maxF = 0;
		for (int right = 0; right < str.length(); right++) {
			int charIndex = str.charAt(right) - 'A';
			frequency[charIndex]++;
			maxF = Math.max(maxF, frequency[charIndex]);
			while ((right - left + 1) - maxF > k) {
				frequency[str.charAt(left) - 'A']--;
				left++;
			}
			result = Math.max(result, right - left + 1);
		}
		return result;
	}

	
	/**
	 * Time complexity : O(n log n)
	 */
	static class SlidingWindowWithBinarySearch {
		static int characterReplacement(String s, int k) {
			int low = 1;
			int hi = s.length() + 1;
			
			while( low + 1 < hi) {
				int mid = (low + hi) / 2;
				if (canMakeValidReplacement(s, mid, k)) {
					low = mid;
				} else {
					hi = mid;
				}
			}
			return low;
		}

		static boolean canMakeValidReplacement(String s, int subStringLength, int k) {
			int[] freqMap = new int[26];
			int maxFrequency = 0;
			int start = 0;
			for (int end = 0; end < s.length(); end++) {
				freqMap[s.charAt(end) - 'A']++;
				if (end + 1 - start > subStringLength) {
					freqMap[s.charAt(start) - 'A'] --;
					start++;
				}
				maxFrequency = Math.max(maxFrequency, freqMap[s.charAt(end) - 'A']);
				if (subStringLength - maxFrequency <= k) {
					return true;
				}
			}
			return false;
		}
	}
	
	/*
	 * Slow Time complexity : O(nm)
	 */
	static class SlidingWindowSlow {
		static int characterReplacement(String s, int k) {
			HashSet<Character> allLetters = new HashSet<>();
			for (int i = 0; i < s.length(); i++) {
				allLetters.add(s.charAt(i));
			}
			int maxLenght = 0;
			for (Character letter : allLetters) {
				int start = 0;
				int count = 0;
				for (int end = 0; end < s.length(); end++) {
					if (s.charAt(end) == letter) {
						count++;
					}
					while(!isWindowValid(start, end, count, k)) {
						if (s.charAt(start) == letter) {
							count --;
						}
						start ++;
					}
					maxLenght = Math.max(maxLenght, end - start + 1);
				}
			}
			return maxLenght;
		}
 
		static boolean isWindowValid(int start, int end, int count, int k) {
			return end - start - count + 1 <= k;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(SlidingWindowWithBinarySearch.characterReplacement("ABABBA", 2));
		System.out.println(SlidingWindowSlow.characterReplacement("ABABBA", 2));
		System.out.println(repetingCharacterReplacement("ABABBA", 2));
		System.out.println(repetingCharacterReplacement("AABABBA", 1));
		System.out.println(repetingCharacterReplacement("ABA", 2));
		System.out.println(repetingCharacterReplacement("ABAB", 2));
	}
}
