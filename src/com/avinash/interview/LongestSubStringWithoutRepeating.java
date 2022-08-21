package com.avinash.interview;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeating {
	
	public static String longestSubStringWithoutRepeatingLen(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0;
		int result = 0;
		String resString = "";
		for (int right = 0; right < s.length(); right ++) {
			while(set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left ++;
			}
			set.add(s.charAt(right));
			if (result < right - left + 1) {
				result = right - left + 1;
				resString = s.substring(left, right + 1);
			}
//			result = Math.max(result, right - left + 1);
		}
		System.out.println(result);
		return resString;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(longestSubStringWithoutRepeatingLen("abcabcbb"));
	}
}
