package com.avinash.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithAtmost2Chars {
	static class SlidingWindow {
		static int lengthOfLongestSubstringTwoDistinct(String s) {
	        int ans = 0;
	        Map<Character, Integer> map = new HashMap<>();
	        for (int left = 0, right = 0; right < s.length(); right++) {
	        	map.put(s.charAt(right), right);
	        	if (map.size() == 3) {
	        		int delIndex = Collections.min(map.values());
	        		map.remove(s.charAt(delIndex));
	        		left = delIndex + 1;
	        	}
	        	ans = Math.max(ans, right - left + 1);
	        }
	        return ans;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(SlidingWindow.lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(SlidingWindow.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
	}
}
