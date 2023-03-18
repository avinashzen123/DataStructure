package com.avinash.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithAlmostKChars {
	static class SlidingWindow {
		static int lengthOfLongestSubstringKDistinct(String s, int k) {
			int length = s.length();
			if (length * k == 0) return 0;
			Map<Character, Integer> rightmostPosition = new HashMap<>();
			int maxLength = 0;
			for (int left = 0, right = 0; right < length; right++) {
				rightmostPosition.put(s.charAt(right), right);
				if (rightmostPosition.size() == k + 1) {
					int lowestPosition = Collections.min(rightmostPosition.values());
					rightmostPosition.remove(s.charAt(lowestPosition));
					left = lowestPosition + 1;
				}
				maxLength = Math.max(maxLength, right - left + 1);
			}
			return maxLength;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(SlidingWindow.lengthOfLongestSubstringKDistinct("eceba", 2));
	}
}
