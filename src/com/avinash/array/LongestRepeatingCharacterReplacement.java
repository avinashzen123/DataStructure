package com.avinash.array;

// Longest Repeating Character Replacement
public class LongestRepeatingCharacterReplacement {
	public static int repetingCharacterReplacement(String str, int k) {
		int[] frequency = new int[26];
		int left = 0;
		int result = 0;
		int maxF = 0;
		for (int right = 0; right < str.length(); right++) {
			int charIndex = str.charAt(right) - 'A';
			frequency[charIndex]++;
			maxF = Math.max(maxF, frequency[charIndex]);
			while((right - left + 1) - maxF > k) {
				frequency[str.charAt(left) - 'A']--;
				left ++;
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
