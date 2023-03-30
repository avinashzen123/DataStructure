package com.avinash.string;

// https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/description/
/**
 * 
 * Given a string s and an integer k, return the number of substrings in s of
 * length k with no repeated characters.
 *
 * Input: s = "havefunonleetcode", k = 5
 * 
 * Output: 6
 * 
 * Explanation: There are 6 substrings they are:
 * 'havef','avefu','vefun','efuno','etcod','tcode'.
 * 
 */
public class KLengthSubStrWithNoRepetation {
	static int numKLenSubstrNoRepeats(String s, int k) {
		if (k > 26)
			return 0;
		int answer = 0;
		int left = 0;
		int right = 0;
		int len = s.length();
		int[] freq = new int[26];
		while (right < len) {
			char ch = s.charAt(right);
			freq[ch - 'a']++;
			while (freq[ch - 'a'] > 1) {
				freq[s.charAt(left++) - 'a']--;
			}
			if (right - left + 1 == k) {
				answer++;
				freq[s.charAt(left++) - 'a']--;
			}
			right++;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 6));
	}
}
