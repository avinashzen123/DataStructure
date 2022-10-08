package com.avinash.array;

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
	 * 
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

	public static void main(String[] args) {
		System.out.println(repetingCharacterReplacement("ABABBA", 2));
		System.out.println(repetingCharacterReplacement("AABABBA", 1));
		System.out.println(repetingCharacterReplacement("ABA", 2));
		System.out.println(repetingCharacterReplacement("ABAB", 2));
	}
}
