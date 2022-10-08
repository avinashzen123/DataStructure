package com.avinash.string;

public class KPallindrom {

	// https://www.youtube.com/watch?v=rmyj8GtVFmo
	public static boolean canConstruct(String s, int k) {
		if (s.length() == k)
			return true;
		if (s.length() < k)
			return false;
		int[] fre = new int[26];
		for (char ch : s.toCharArray()) {
			fre[ch - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (fre[i] % 2 != 0)
				count++;
		}
		return (count <= k);
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("annabelle", 2));
		System.out.println(canConstruct("leetcode", 3));
	}
}
