package com.avinash.string;

import java.util.*;

public class LongestSubStringWithoutRepetation {

	static class BruteForce {
		static int lengthOfLongestSubString(String s) {
			int n = s.length();
			int res = 0;
			for (int i =0; i < n ; i++) {
				for (int j = 0; j < n ; j++) {
					if (checkRepetition(s, i, j)) {
						res = Math.max(res, j - i + 1);
					}
				}	
			}
			return res;
		}

		static boolean checkRepetition(String s, int start, int end) {
			Set<Character> chars = new HashSet<>();
			for (int i = start; i < end; i++) {
				char c = s.charAt(i);
				if(chars.contains(c)) {
					return false;
				}
				chars.add(c);
			}
			return true;
		}
	}
	
	static class SlidingWindow {
		static int lengthOfLongestSubstring(String s) {
			Map<Character, Integer> chars = new HashMap<>();
			int left = 0;
			int right = 0;
			int res = 0;
			while(right < s.length()) {
				char r = s.charAt(right);
				chars.put(r, chars.getOrDefault(r, 0) + 1);
				while(chars.get(r) > 1) {
					char l = s.charAt(left);
					chars.put(l, chars.get(l) - 1);
					left++;
				}
				res = Math.max(res, right - left + 1);
				right ++;
			}
			return res;
		}
	}
	
	static class SlidingWindow1 {
		static int lengthOfLongestSubstring(String s) {
	        int ans = 0;
	        Map<Character, Integer> map = new HashMap<>();
	        for (int left = 0, right = 0; right < s.length(); right++) {
	            if (map.containsKey(s.charAt(right))) {
	                left = Math.max(map.get(s.charAt(right)), left);
	            }
	            ans = Math.max(ans, right - left + 1);
	            map.put(s.charAt(right), right + 1 );
	        }
	        return ans;
		}
	}
	
	
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
		System.out.println(BruteForce.lengthOfLongestSubString("clementisacap"));
		System.out.println(SlidingWindow.lengthOfLongestSubstring("clementisacap"));
		System.out.println(SlidingWindow1.lengthOfLongestSubstring("clementisacap"));
		
		
		System.out.println(longestSubstringWithoutDuplication("clementisacap"));
		System.out.println(longestSubstringWithoutDuplication("abacaaaeaaafa"));
		System.out.println(longestSubstringWithoutDuplication("abcbde"));
		System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));
		System.out.println(longestSubstringWithoutDuplication("abccdeaabbcddef"));// Not working
		
		System.out.println(longestSubstringWithoutDuplication("abccdeaabbcddef"));
	}
}
