package com.avinash.string;

import java.util.HashSet;

public class StringLengthProblems {
	/*
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
	 */
	public static int lengthOfLongestSubString(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int left = 0, right = 0; right < s.length(); right ++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("abbbb"));
    }
}
