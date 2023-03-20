package com.avinash.string;

// https://leetcode.com/problems/valid-palindrome-ii/description/
public class ValidPallindromByDeletingAtMostOneChar {

	static boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while(left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return checkPallindrom(s, left, right -1) || checkPallindrom(s, left + 1, right);
			}
			left ++;
			right --;
		}
		return true;
	}
	
	static boolean checkPallindrom(String s, int start, int end) {
		while(start < end) {
			if (s.charAt(start ++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abc"));
		System.out.println(validPalindrome("abca"));
	}
}
