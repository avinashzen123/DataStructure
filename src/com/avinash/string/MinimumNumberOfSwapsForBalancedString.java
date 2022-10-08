package com.avinash.string;

public class MinimumNumberOfSwapsForBalancedString {
	public static int minSwaps(String s) {
		int close = 0;
		int swap = 0;
		for (char c : s.toCharArray()) {
			if (c == '[') {
				close++;
			} else {
				close--;
			}
			if (close < 0) {
				swap = Math.max(swap, -1 * close);
			}

		}
		return swap/ 2 + (swap & 1);
	}
	
	public static void main(String[] args) {
		System.out.println(minSwaps("][]["));
		System.out.println(minSwaps("]]][[["));
	}

}
