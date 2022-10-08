package com.avinash.string;

public class PallindromicStrings {
	//https://leetcode.com/problems/palindromic-substrings/
	public static int countSubstrings(String s) {
		if (s.length() < 2) return s.length();
		
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i;
			while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				result ++;
				left --;
				right ++;
			}
			//even length;
			left = i;
			right = i + 1;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				result ++;
				left --;
				right ++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(countSubstrings("aaa"));
	}
}
