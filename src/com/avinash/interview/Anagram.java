package com.avinash.interview;

public class Anagram {

	public static boolean solve(String s1, String s2) {
		int[] frequencey = new int[26];
		for (char c : s1.toCharArray()) {
			++frequencey[c - 'a'];
		}
		for (char c : s2.toCharArray()) {
			--frequencey[c - 'a'];
		}
		for (int i : frequencey) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(solve("adam", "daniel"));
		System.out.println(solve("adam", "mdaa"));
		System.out.println(solve("rat", "car"));
	}
}
