package com.avinash.sliding.window;

import java.util.HashSet;

public class LongestSubringWithoutRepeatingCharacter {

	public static int longestSubString(String str) {
		HashSet<Character> charSet = new HashSet<>();
		int left = 0;
		int result = 0;
		for (int right = 0; right < str.length(); right++) {
			while (charSet.contains(str.charAt(right))) {
				charSet.remove(str.charAt(left++));
			}
			charSet.add(str.charAt(right));
			result = Math.max(result, right - left + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(longestSubString("abcbdacbcabb"));
	}

}
