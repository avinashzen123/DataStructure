package com.avinash.string;

// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/description/
/**
 * You are given two strings s1 and s2 of equal length consisting of letters "x"
 * and "y" only. Your task is to make these two strings equal to each other. You
 * can swap any two characters that belong to different strings, which means:
 * swap s1[i] and s2[j].
 * 
 * Return the minimum number of swaps required to make s1 and s2 equal, or
 * return -1 if it is impossible to do so.
 * 
 * Input: s1 = "xx", s2 = "yy"
 * 
 * Output: 1
 * 
 * Explanation: Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
 * 
 * Input: s1 = "xy", s2 = "yx"
 * 
 * Output: 2
 * 
 * Explanation: Swap s1[0] and s2[0], s1 = "yy", s2 = "xx". Swap s1[0] and
 * s2[1], s1 = "xy", s2 = "xy". Note that you cannot swap s1[0] and s1[1] to
 * make s1 equal to "yx", cause we can only swap chars in different strings.
 */
public class MinSwapToMakeStringEquals {

	public int minimumSwap(String s1, String s2) {
		int len = s1.length();
		int countX1 = 0;
		int countY1 = 0;
		int countX2 = 0;
		int countY2 = 0;
		
		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (s1.charAt(i) == 'x') {
					countX1++;
				} else {
					 countY1++;
				}
				if (s2.charAt(i) == 'x') {
					countX2++;
				} else {
					 countY2++;
				}
			}
		}
		if ((countX1 + countX2) % 2 == 1) {
			return -1;
		}
		if (countX1 + countX2 > countY1 + countY2) {
			return (int) (Math.ceil(countY1 / 2.0) + Math.ceil(countY2) / 2.0);		}
		return (int) (Math.ceil(countX1 / 2.0 )+ Math.ceil(countX2 / 2.0));
	}
	
	public static void main(String[] args) {
		MinSwapToMakeStringEquals equals = new MinSwapToMakeStringEquals();
		System.out.println(equals.minimumSwap("xx", "yy"));
	}
}
