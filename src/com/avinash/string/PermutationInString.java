package com.avinash.string;

import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {
	static class BruteForce {
		boolean flag = false;
		public boolean checkInclusion(String s1, String s2) {
	        permute(s1, s2, 0);
			return flag;
	    }
		private void permute(String s1, String s2, int l) {
			if (l == s1.length()) {
				if (s2.indexOf(s1) >= 0) {
					flag = true;
				}
			} else {
				for (int i = l; i < s1.length(); i++) {
					s1 = swap(s1, l, i);
					permute(s1, s2, l + 1);
					s1 = swap(s1, l, i);
				}
			}
		}
		private String swap(String s, int i0, int i1) {
			if (i0 == i1) return s;
			String s1 = s.substring(0, i0);
			String s2 = s.substring(i0 + 1, i1);
			String s3 = s.substring(i1 + 1);
			return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
		}
	}
	
	static class UsingSort {
		public boolean checkInclusion(String s1, String s2) {
			s1 = sort(s1);
			System.out.println("S1  " + s1);
			for (int i = 0; i <= s2.length() - s1.length(); i++) {
				System.out.println(s2.substring(i, i + s1.length()));
				if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
					return true;
				}
			}
			return false;
		}
		private String sort(String s) {
			char[] t = s.toCharArray();
			Arrays.sort(t);
			return new String(t);
		}
	}
	
	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(new UsingSort().checkInclusion(s1, s2));
		s1 = "ab";
		s2 = "eidboaoo";
		System.out.println(new UsingSort().checkInclusion(s1, s2));
	}
}
