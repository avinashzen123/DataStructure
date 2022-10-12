package com.avinash.string;


// https://www.youtube.com/watch?v=MOeuK6gaC2A
public class MinFlipToMakeBinaryStringAlternating {

	// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
	public static int minFlips(String s) {
		int n  = s.length();
		s = s + s;
		String alt1 = "";
		String alt2 = "";
		for (int i = 0; i < s.length(); i++) {
			alt1 += i%2 == 0 ? "0" : "1";
			alt2 += i%2 == 0 ? "1" : "0";
		}
		int res = s.length();
		int diff1 = 0;
		int diff2 = 0;
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			if (s.charAt(right) != alt1.charAt(right)) {
				diff1++;
			}
			if (s.charAt(right) != alt2.charAt(right)) {
				diff2++;
			}
			if (right - left + 1 > n) {
				if (s.charAt(left) != alt1.charAt(left)) {
					diff1--;
				}
				if (s.charAt(left) != alt2.charAt(left)) {
					diff2--;
				}
				left++;
			}
			if (right - left + 1 == n) {
				res = Math.min(res, Math.min(diff1, diff2));
			}
		}
		return res;
	}

	
	
	public static void main(String[] args) {
		System.out.println(minFlips("111000"));
	}

}
