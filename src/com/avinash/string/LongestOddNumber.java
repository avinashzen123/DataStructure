package com.avinash.string;

// https://leetcode.com/problems/largest-odd-number-in-string/description/?languageTags=java
public class LongestOddNumber {
	public String largestOddNumber(String num) {
		int length = num.length();
		for (int i = length - 1; i >= 0; i--) {
			if (num.charAt(i) % 2 != 0) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		LongestOddNumber oddNumber = new LongestOddNumber();
		System.out.println(oddNumber.largestOddNumber("525"));
	}
}
