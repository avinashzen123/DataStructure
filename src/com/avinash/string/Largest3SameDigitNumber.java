package com.avinash.string;

public class Largest3SameDigitNumber {
	// https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
	public static String largestGoodInteger(String num) {
		if (num.length() < 2) return "";
		Integer largNum = null;
		for (int i = 2; i < num.length(); i++) {
			if (num.charAt(i - 2) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i)) {
				if (largNum == null) {
					largNum = Integer.parseInt(num.substring(i - 2, i + 1));
				} else {
					largNum = Math.max(largNum, Integer.parseInt(num.substring(i - 2, i + 1)));
				}
			}
		}
		return largNum == null ? "" : String.valueOf(largNum);
	}
	
	public static void main(String[] args) {
		System.out.println(largestGoodInteger("6777133339"));
		System.out.println(largestGoodInteger("2300019"));
		System.out.println(largestGoodInteger("42352338"));
	}
}
